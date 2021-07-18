package com.example.myapplication.retrofit.entity


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ExampleThird {
    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("data")
    @Expose
    var data: List<List<DataThird>>? = null
}