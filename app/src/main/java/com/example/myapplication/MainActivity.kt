package com.example.myapplication


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import okhttp3.*
import okhttp3.Headers.Companion.headersOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*
import javax.security.cert.CertificateException


class MainActivity() : AppCompatActivity() {

   lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bottomNavigationView = findViewById<View>(R.id.bottom_navigation_bar) as BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.action_recents -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,ConclusionFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.action_favorites -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,ConclusionFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.action_nearby -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout,ConclusionFragment()).commit()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        initRetorfit()
        initPostMessage()
    }

    private fun initPostMessage() {

        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("a","add_entry")
            .addFormDataPart("session","1")
            .addFormDataPart("body","asdsadasdsadasdasdsad")
            .build()


        val apiService = retrofit.create(ApiService::class.java)
        apiService.postMessage(
            requestBody
        )
            .enqueue(object : Callback<Datum> {
                override fun onResponse(call: Call<Datum>, response: Response<Datum>) {
                    Log.d("TAG1", "onResponse: ${response.body()}")
                }

                override fun onFailure(call: Call<Datum>, t: Throwable) {
                    Log.d("TAG1", "onFailure: $t")
                }

            })

//        apiService.getMessage().enqueue(object: Callback<Datum>{
//            override fun onResponse(call: Call<Datum>, response: Response<Datum>) {
//                Log.d("TAG1", "onResponse: $response")
//            }
//
//            override fun onFailure(call: Call<Datum>, t: Throwable) {
//                Log.d("TAG1", "onFailure: $t")
//            }
//        })
    }


    private fun getUnsafeOkHttpClient(): OkHttpClient? {
        return try {
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate?>?,
                        authType: String?
                    ) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<X509Certificate?>?,
                        authType: String?
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<X509Certificate?>? {
                        return arrayOf()
                    }
                }
            )

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            val sslSocketFactory = sslContext.socketFactory
            val trustManagerFactory: TrustManagerFactory =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
            trustManagerFactory.init(null as KeyStore?)
            val trustManagers: Array<TrustManager> =
                trustManagerFactory.trustManagers
            check(!(trustManagers.size != 1 || trustManagers[0] !is X509TrustManager)) {
                "Unexpected default trust managers:" + trustManagers.contentToString()
            }

            val trustManager =
                trustManagers[0] as X509TrustManager


            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustManager)
            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
            builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun initRetorfit() {


        val builder = OkHttpClient.Builder()
//        builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
//        builder.addInterceptor { chain ->
//            val newRequest = chain.request().newBuilder()
//                .addHeader("token", "VfQKOIY-Wh-aR2ltnl")
//                .build()
//            chain.proceed(newRequest)
//        }
        builder.build()


             retrofit = Retrofit.Builder()
            .baseUrl("https://bnet.i-partner.ru/")
            .client(builder.build())
            .client(getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        apiService.getResponse(
            MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("a", "new_session")
                .build()
        )
            .enqueue(object : Callback<Example> {
                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    Log.d("TAG2", "onResponse: ${response.body()?.data?.session}")
                }

                override fun onFailure(call: Call<Example>, t: Throwable) {
                    Log.d("TAG2", "onFailure: $t")
                }

            })

    }


}