package com.example.myapplication.retrofit.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class DataThird {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("body")
    @Expose
    var body: String? = null

    @SerializedName("da")
    @Expose
    var da: String? = null

    @SerializedName("dm")
    @Expose
    var dm: String? = null
}