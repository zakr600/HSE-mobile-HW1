package com.example.hw1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_filter.view.*

class FilterAdapter(private val dat: ArrayList<String>) : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox = itemView.checkBox
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_filter, parent, false))

    override fun getItemCount(): Int =
        dat.size

    override fun onBindViewHolder(holder: FilterAdapter.ViewHolder, position: Int) {
        holder.checkBox.text = dat[position]
    }
}
