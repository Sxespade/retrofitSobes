package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Singleton
import com.example.myapplication.data.state.AppState
import com.example.myapplication.retrofit.RetrofitImplementation
import com.example.myapplication.retrofit.entity.DataThird
import com.example.myapplication.retrofit.entity.Example
import com.example.myapplication.retrofit.entity.ExampleThird
import com.example.myapplication.view.adapters.MessagesAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConclusionViewModel(private val retrofitImplementation: RetrofitImplementation): BaseViewModel<AppState>() {

    var session = ""

    fun subscribe(): LiveData<AppState> = liveDataViewmodel

    fun loadRecycle(recyclerView: RecyclerView) {
        initRetrofit(recyclerView)
    }

    private fun initRetrofit(recyclerView: RecyclerView) {
        viewModelCoroutineScope.launch {
            retrofitGetMessages(Singleton.getSession().toString(),recyclerView)
        }
    }


    private fun retrofitGetMessages(str: String,recyclerView: RecyclerView) {
        retrofitImplementation.initRetorfit().getMessages(
            MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("a", "get_entries")
                .addFormDataPart("session", str)
                .build()
        ).enqueue(object: Callback<ExampleThird>{
            override fun onResponse(call: Call<ExampleThird>, response: Response<ExampleThird>) {
                Log.d("TAG3", "onResponse: ${response.body()?.data}")
                var dataThirdList = response.body()?.data as List<List<DataThird>>
                Log.d("TAG3", "onResponse: ${dataThirdList[0]}")
                recyclerView.adapter = MessagesAdapter(dataThirdList[0])
            }

            override fun onFailure(call: Call<ExampleThird>, t: Throwable) {
                Log.d("TAG3", "onFailure: $t")
            }
        })


    }


    override fun errorReturned(t: Throwable) {
    }
}