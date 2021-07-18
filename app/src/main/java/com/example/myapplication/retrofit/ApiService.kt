package com.example.myapplication.retrofit

import com.example.myapplication.retrofit.entity.Example
import com.example.myapplication.retrofit.entity.ExampleSecond
import com.example.myapplication.retrofit.entity.ExampleThird
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @Headers("token: VfQKOIY-Wh-aR2ltnl")
    @POST("testAPI/")
    fun getResponse(@Body data: RequestBody): Call<Example>


    @Headers("token: VfQKOIY-Wh-aR2ltnl")
    @POST("testAPI/")
    fun postMessage(@Body data: RequestBody): Call<ExampleSecond>

    @Headers("token: VfQKOIY-Wh-aR2ltnl")
    @POST("testAPI/")
    fun getMessages(@Body data: RequestBody): Call<ExampleThird>

}