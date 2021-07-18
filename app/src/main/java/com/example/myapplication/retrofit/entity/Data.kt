package com.example.myapplication.retrofit.entity

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("session")
//    @Expose
    var session: String? = null
)