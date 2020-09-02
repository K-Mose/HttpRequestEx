package com.example.httprequestex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_strat.*

class StratActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strat)

        listView.setOnClickListener {
            val intent = Intent(this@StratActivity, MainActivity::class.java)
            startActivity(intent)
        }

        recylcerView.setOnClickListener {
            val intent = Intent(this@StratActivity, RecyclerView::class.java)
            startActivity(intent)
        }
        toRefreshLayout.setOnClickListener {
            val intent = Intent(this@StratActivity, SwipeRefresh::class.java)
            startActivity(intent)
        }
    }
}
