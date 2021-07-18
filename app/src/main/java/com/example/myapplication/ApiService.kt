package com.example.myapplication

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @Headers("token: VfQKOIY-Wh-aR2ltnl")
    @POST("testAPI/")
    fun getResponse(
        @Body data: RequestBody
    ): Call<Example>

    @POST("testAPI/")
    fun postMessage(
        @Body data: RequestBody
    ): Call<Datum>

    @GET("testAPI/")
    fun getMessage(): Call<Datum>

}