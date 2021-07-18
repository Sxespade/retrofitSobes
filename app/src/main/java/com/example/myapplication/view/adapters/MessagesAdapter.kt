package com.example.myapplication.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.retrofit.entity.DataThird

class MessagesAdapter(private val data: List<DataThird>) : RecyclerView.Adapter<MessagesAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<View>(R.id.textView) as TextView
        val textView3: TextView = view.findViewById<View>(R.id.textView3) as TextView
        val textView5: TextView = view.findViewById<View>(R.id.textView5) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.message_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data1 = data[position].body
        holder.textView.text = data1
        holder.textView3.text = data[position].da
        holder.textView5.text = data[position].dm
    }


    override fun getItemCount(): Int {
        return data.size
    }

}