package com.example.httprequestex

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.ContentView
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import com.bumptech.glide.Glide
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.row_layout.*

// Android Kotlin Usage Tutorial #084 - JSON and Http request
// https://www.youtube.com/watch?v=6zET-_h8VZg
class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "HTTP_REQEUST_TAG :"
        val TAGdE = "DESCRIPTION::"
        var width = 0
        var height = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels

        width_height.setText("${width.toString()} x ${height.toString()}")
        Log.d("WH:", "${width.toString()}, ${height.toString()}")
//        val url = getString(R.string.url_head)+"address?longitude=127.1394687&latitude=37.5369472"
        search.setOnClickListener {
            val area1 = area1.text
            val area2 = area2.text
//            val area3 = area3.text
            val area3 = if(area3.text.contains("a")) "성내동" else if(area3.text.contains("2")) "천호동" else if(area3.text.contains("3")) "길동" else "둔촌동"
            Toast.makeText(this, "$area1 $area2 $area3", Toast.LENGTH_SHORT).show()

            visibleLoading()
            imageShow()


            val url = "http://210.123.254.17:5001/api/matzip?area1Name=${area1}&area2Name=${area2}&area3Name=${area3}"
            try{
                AsyncTaskHandleJson().execute(url)
            }catch (e:Exception) {
                Toast.makeText(this, "에러", Toast.LENGTH_SHORT).show()
            }
        }


    }

    inner class AsyncTaskHandleJson : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg url: String?): String {
            var text: String
            val connection = URL(url[0]).openConnection() as HttpURLConnection
            try {
                connection.connect()
                text =
                    connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
            } finally {
                connection.disconnect()
            }
            return text
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
//            Log.d(TAG, "${result.toString()}")
            handleJson(result!!)
        }

    }

    private fun handleJson(jsonString: String) {

        val list = ArrayList<StoreClass>()
        list.clear()
        val jsonObject = JSONObject(jsonString)
        Log.d(TAG, "${jsonObject}")
        val jsonList = JSONArray(jsonObject["matzipList"].toString())
//        Log.d(TAG2, "list1_: ${jsonList[0]}")
//        Log.d(TAG2, "list2_: ${jsonList[1]}")
//        Log.d(TAG2, "list3_: ${jsonList[2]}")
        var i = 0
        while (i < jsonList.length()){
            val storeObject = JSONObject(jsonList[i].toString())
            Log.d(TAG, "$storeObject")
            val thumbnails = JSONArray(storeObject.getString("thumbnailUrls"))
            val thumbList:ArrayList<String> = ArrayList()
            var j = 0
            if(thumbnails.length() > 0)
                while(j < thumbnails.length()){
                    thumbList.add(thumbnails[j].toString())
                    j++
                }
            else
                thumbList.add("https://icon-library.com/images/meal-icon-png/meal-icon-png-11.jpg")
            val a = storeObject.getString("description").replace(storeObject.getString("title"), "").replace(storeObject.getString("category"),"").replace(storeObject.getString("delievery"),"")
            Log.d(TAGdE, "$a")
            list.add(
                StoreClass(
                    storeObject.getString("title"),
                    storeObject.getString("category"),
                    storeObject.getString("delievery"),
                    storeObject.getString("star"),
                    thumbList,
//                    storeObject.getString("description"),
                    a,
                    storeObject.getString("visitorReview"),
                    storeObject.getString("blogReview")
//                    storeObject.getString("detailPageUrl")
                )
            // 디스크립션 수정하기
            // 타이틀 뺴고 카테고리, 배달 뺴기. 방영
            )

            i++
        }


        val adapter = ListAdapte(this, list)
        president_list.adapter = adapter

        invisibleLoading()
    }

    // image show
    private fun imageShow() {
        Glide.with(this).load(R.drawable.loading_gif).into(image_view)
    }

    private fun visibleLoading() {
        loadingLayout.visibility = View.VISIBLE
    }
    private fun invisibleLoading() {
        loadingLayout.visibility = View.INVISIBLE
    }
}
