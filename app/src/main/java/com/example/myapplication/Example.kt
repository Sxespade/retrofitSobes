package com.example.myapplication


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Example (
    @SerializedName("status")
    @Expose
    var status: Int? = null,
    @SerializedName("data")
    @Expose
    var data: Data? = null
)