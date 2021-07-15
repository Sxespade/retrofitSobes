package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @POST("/")
    fun getResponse(
        @Header("token") token: String,
        @Body data: String
    ): Call<Example>

}