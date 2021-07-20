package com.example.myapplication.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.retrofit.entity.DataThird
import java.text.SimpleDateFormat
import java.util.*

class MessagesAdapter(private val data: List<DataThird>, private val onClickListener: MyOnClickListener) : RecyclerView.Adapter<MessagesAdapter.MyViewHolder>() {

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
        val dateDa = getDate(data[position].da)
        holder.textView3.text = dateDa.toString()
        val dateDm = getDate(data[position].dm)
        holder.textView5.text = dateDm.toString()

        holder.textView.setOnClickListener{
            onClickListener.onClicked(data1.toString())
        }
    }

    private fun getDate(da: String?): Any {
        val date = da!!.toLong()
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = date*1000;
        return formatter.format(calendar.time)
    }


    override fun getItemCount(): Int {
        return data.size
    }

}