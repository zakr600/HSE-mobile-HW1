package com.example.hw1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val KEY_CHECKED = "checked"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checked = (savedInstanceState?.get(KEY_CHECKED) ?: booleanArrayOf(true, true, true)) as BooleanArray
        val dat = Dat("Кравчук Захар", "10 класс", "http://github.com/zakr600", "Можно сделать приложение-записную книжку, где будут записываться какие-то предстоящие события, а затем в нужное время приложение напомнит о нём", arrayListOf("С++", "Python", "Kotlin"), arrayListOf("3 года", "2 года", "2 года"), checked)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = MainAdapter(dat, this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val newChecked = data.getBooleanArrayExtra(KEY_CHECKED) ?: (recycler.adapter as MainAdapter).dat.checked
            (recycler.adapter as MainAdapter).dat.checked = newChecked
            (recycler.adapter as MainAdapter).notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBooleanArray(KEY_CHECKED, (recycler.adapter as MainAdapter).dat.checked)
    }
}
