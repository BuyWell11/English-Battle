package com.englishbattle.myapplication.tasks_types.mds_tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MdsAdapter(ItemList: MutableList<String>) : RecyclerView.Adapter<MdsAdapter.MyViewHolder>() {
    private var list: MutableList<String> = ItemList

    inner class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var text: TextView = ItemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.mds_text_space, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = list[position]
    }

}