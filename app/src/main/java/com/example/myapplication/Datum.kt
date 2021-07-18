package com.example.myapplication

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Datum {
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