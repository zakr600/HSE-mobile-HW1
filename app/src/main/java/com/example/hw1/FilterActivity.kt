package com.example.hw1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*
import kotlinx.android.synthetic.main.activity_main.recycler

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val checked = intent.getBooleanArrayExtra("checked")
        val skills = intent.getStringArrayListExtra("skills")
        if (skills != null)
            recycler.adapter = FilterAdapter(skills, checked)
        recycler.layoutManager = LinearLayoutManager(this)

        setActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        ok_btn.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent().putExtra("checked", (recycler.adapter as FilterAdapter).checked))
            finish()
        }
    }
}
