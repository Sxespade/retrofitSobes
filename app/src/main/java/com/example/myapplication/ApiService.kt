package com.example.myapplication

import okhttp3.RequestBody
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
        @Body requestBody: RequestBody
    ): Call<Datum>

}