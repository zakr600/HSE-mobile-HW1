package com.example.hw1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dat = Dat("Zakhar", "10 класс", "http://github.com/zakr600", "Sample text", arrayListOf("dasdas", "C", "3"), arrayListOf("1y", "2y", "3y"))
        for (i in 0..100) {
            dat.skills.add(i.toString())
            dat.durations.add(i.toString())
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MainAdapter(dat)
    }
}
