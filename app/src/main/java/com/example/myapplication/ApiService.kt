package com.example.myapplication

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {


    @POST("testAPI/")
    fun getResponse(
        @Body data: RequestBody
    ): Call<Datum>

    @POST("testAPI/")
    fun postMessage(
        @Body datum: Datum
    ): Call<ResponseBody>

}