package com.example.myapplication

import android.app.Application
import android.util.Log
import com.example.myapplication.di.conclusionFragmentModuule
import com.example.myapplication.di.createFragmentModuule
import com.example.myapplication.retrofit.ApiService
import com.example.myapplication.retrofit.entity.Example
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    conclusionFragmentModuule,
                    createFragmentModuule
                )
            )
        }

        Singleton.setSession("hVfXK6QP2i1VIkGKUB")

//        if (Singleton.getSession()==null) {
//        getResponseRetrofit()}
    }

//    private fun getUnsafeOkHttpClient(): OkHttpClient? {
//        return try {
//            val trustAllCerts = arrayOf<TrustManager>(
//                object : X509TrustManager {
//                    @Throws(CertificateException::class)
//                    override fun checkClientTrusted(
//                        chain: Array<X509Certificate?>?,
//                        authType: String?
//                    ) {
//                    }
//
//                    @Throws(CertificateException::class)
//                    override fun checkServerTrusted(
//                        chain: Array<X509Certificate?>?,
//                        authType: String?
//                    ) {
//                    }
//
//                    override fun getAcceptedIssuers(): Array<X509Certificate?>? {
//                        return arrayOf()
//                    }
//                }
//            )
//
//            val sslContext = SSLContext.getInstance("SSL")
//            sslContext.init(null, trustAllCerts, SecureRandom())
//            val sslSocketFactory = sslContext.socketFactory
//            val trustManagerFactory: TrustManagerFactory =
//                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
//            trustManagerFactory.init(null as KeyStore?)
//            val trustManagers: Array<TrustManager> =
//                trustManagerFactory.trustManagers
//            check(!(trustManagers.size != 1 || trustManagers[0] !is X509TrustManager)) {
//                "Unexpected default trust managers:" + trustManagers.contentToString()
//            }
//
//            val trustManager =
//                trustManagers[0] as X509TrustManager
//
//
//            val builder = OkHttpClient.Builder()
//            builder.sslSocketFactory(sslSocketFactory, trustManager)
//            builder.hostnameVerifier(HostnameVerifier { _, _ -> true })
//            builder.build()
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }
//
//    fun initRetorfit(): ApiService {
//        val builder = OkHttpClient.Builder()
//        builder.build()
//
//        return Retrofit.Builder()
//            .baseUrl("https://bnet.i-partner.ru/")
//            .client(OkHttpClient.Builder().build())
//            .client(getUnsafeOkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//
//    }
//
//    private fun getResponseRetrofit() {
//        initRetorfit().getResponse(
//            MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("a", "new_session")
//                .build()
//        )
//            .enqueue(object : Callback<Example> {
//                override fun onResponse(call: Call<Example>, response: Response<Example>) {
//                    Log.d("TAG2", "onResponse: ${response.body()?.data?.session}")
//                    var session = response.body()?.data?.session.toString()
//                    Singleton.setSession(session)
//                }
//
//                override fun onFailure(call: Call<Example>, t: Throwable) {
//                    Log.d("TAG2", "onFailure: $t")
//                }
//
//            })
//    }
}
