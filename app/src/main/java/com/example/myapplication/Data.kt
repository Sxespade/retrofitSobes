package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("session")
//    @Expose
    var session: String? = null
)