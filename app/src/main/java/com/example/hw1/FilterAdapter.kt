package com.example.hw1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_filter.view.*
import java.util.ArrayList

class FilterAdapter(var dat: ArrayList<String>, var checked: BooleanArray) : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox = itemView.checkBox

        init {
            checkBox.setOnClickListener {
                val isChecked = checkBox.isChecked
                if (adapterPosition != 0) {
                    checked[adapterPosition - 1] = isChecked
                    notifyItemChanged(0)
                } else {
                    for (i in checked.indices) {
                        checked[i] = isChecked
                    }
                    notifyDataSetChanged()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_filter, parent, false))

    override fun getItemCount(): Int =
        dat.size + 1

    override fun onBindViewHolder(holder: FilterAdapter.ViewHolder, position: Int) {
        if (position == 0) {
            holder.checkBox.text = "Всё"
            var isChecked = true

            for (i in checked) {
                if (!i) {
                    isChecked = false
                }
            }
            holder.checkBox.isChecked = isChecked
        } else {
            holder.checkBox.text = dat[position - 1]
            holder.checkBox.isChecked = checked[position - 1]
        }
    }
}
