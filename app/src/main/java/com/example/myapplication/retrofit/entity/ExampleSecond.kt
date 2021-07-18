package com.example.myapplication.retrofit.entity


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExampleSecond (
    @SerializedName("status")
    @Expose
    var status: Int? = null,
    @SerializedName("data")
    @Expose
    var data: DataSecond? = null
)