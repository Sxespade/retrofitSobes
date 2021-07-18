package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.Singleton
import com.example.myapplication.data.state.AppState
import com.example.myapplication.retrofit.RetrofitImplementation
import com.example.myapplication.retrofit.entity.Example
import com.example.myapplication.retrofit.entity.ExampleSecond
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateViewModel(private val retrofitImplementation: RetrofitImplementation): BaseViewModel<AppState>() {

    var session = "String"

    fun subscribe(): LiveData<AppState> = liveDataViewmodel

    fun initRetrofit(str: String) {
        viewModelCoroutineScope.launch {
            getResponseRetrofit()
            delay(500)
            retrofitPostMessage(str)
        }
    }

    private fun retrofitPostMessage(str: String) {
        val requestBody: RequestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("a", "add_entry")
            .addFormDataPart("session", session)
            .addFormDataPart("body", str)
            .build()


        retrofitImplementation.initRetorfit().postMessage(
            requestBody
        )
            .enqueue(object : Callback<ExampleSecond> {
                override fun onResponse(
                    call: Call<ExampleSecond>,
                    response: Response<ExampleSecond>
                ) {
                    Log.d("TAG1", "onResponse: ${response.body()?.data?.id}")
                }

                override fun onFailure(call: Call<ExampleSecond>, t: Throwable) {
                    Log.d("TAG1", "onFailure: $t")
                }

            })
    }


    private fun getResponseRetrofit() {
        retrofitImplementation.initRetorfit().getResponse(
            MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("a", "new_session")
                .build()
        )
            .enqueue(object : Callback<Example> {
                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    Log.d("TAG2", "onResponse: ${response.body()?.data?.session}")
                    session = response.body()?.data?.session.toString()
                    Singleton.setSession(session)
                }

                override fun onFailure(call: Call<Example>, t: Throwable) {
                    Log.d("TAG2", "onFailure: $t")
                }

            })
    }


    override fun errorReturned(t: Throwable) {
        TODO("Not yet implemented")
    }
}