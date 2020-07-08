package com.example.hw1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        recycler.adapter = FilterAdapter(arrayListOf<String>("1", "2", "3", "4", "5"))
        recycler.layoutManager = LinearLayoutManager(this)
    }
}
