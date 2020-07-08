package com.example.hw1

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import kotlinx.android.synthetic.main.item_description.view.*
import kotlinx.android.synthetic.main.item_skill.view.*
import kotlinx.android.synthetic.main.item_user_info.view.*
import kotlin.math.min

data class Dat(val name: String, val form: String, val github_url: String, val description: String, val skills: ArrayList<String>, val durations: ArrayList<String>)

class MainAdapter(private val dat: Dat) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class UserInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.user_name
        var form = itemView.user_form
        var github_btn = itemView.github_btn

        init {
            github_btn.setOnClickListener {
                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://github.com/zakr600/")))
            }
        }
    }

    inner class DescriptionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var description = itemView.text
    }

    inner class SkillHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var skill = itemView.skill
        var duration = itemView.duration
    }

    private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filter_btn = itemView.filter_btn
        init {
            filter_btn.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context.applicationContext, FilterActivity::class.java))
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        min(position, 3)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> UserInfoHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false))
            1 -> DescriptionHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_description, parent, false))
            2 -> ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
            else -> SkillHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false))
        }

    override fun getItemCount(): Int =
        dat.skills.size + 3

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = getItemViewType(position)
        when (type) {
            0 -> {
                val hld = holder as UserInfoHolder
                hld.name.text = dat.name
                hld.form.text = dat.form
            }
            1 -> {
                val hld = holder as DescriptionHolder
                hld.description.text = dat.description
            }
            3 -> {
                val hld = holder as SkillHolder
                val pos = position - 3
                hld.skill.text = dat.skills[pos]
                hld.duration.text = dat.durations[pos]
            }
        }
    }
}
