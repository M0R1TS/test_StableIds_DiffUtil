package ru.devsokovix.test_stableids_diffutil

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var data: Array < Int > ): RecyclerView.Adapter < RecyclerView.ViewHolder > () {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as TextView).text = "${data[position]}"
    }

    override fun getItemCount(): Int {
        return data.size
    }
}