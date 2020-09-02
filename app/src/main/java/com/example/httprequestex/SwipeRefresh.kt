package com.example.httprequestex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.area3
import kotlinx.android.synthetic.main.activity_main.president_list
import kotlinx.android.synthetic.main.activity_swipe_refresh.*

class SwipeRefresh : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_refresh)

        refreshLayout.setOnRefreshListener {
            Log.d(MainActivity.TAG, "refresh!!")
            Toast.makeText(this, "REFREHS!!", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                refreshLayout.isRefreshing = false
            }, 2000)
        }
    }
}
