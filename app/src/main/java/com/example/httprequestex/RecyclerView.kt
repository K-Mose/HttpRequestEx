package com.example.httprequestex

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.image_view
import kotlinx.android.synthetic.main.activity_main.loadingLayout
import kotlinx.android.synthetic.main.activity_recycler_view.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class RecyclerView : AppCompatActivity() {


    companion object {
        val TAG = "HTTP_REQEUST_TAG :"
        val TAGdE = "DESCRIPTION::"
        var width = 0
        var height = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels

        search2.setOnClickListener {
            width_height2.setText("$width X $height")
            val area1 = area21.text
            val area2 = area22.text
//            val area3 = area3.text
            val area3 = if(area23.text.contains("1")) "성내동" else if(area23.text.contains("2")) "천호동" else if(area23.text.contains("3")) "길동" else "둔촌동"
            Toast.makeText(this, "$area1 $area2 $area3", Toast.LENGTH_SHORT).show()

            visibleLoading()
            imageShow()


            val url = "http://210.123.254.17:5001/api/matzip?area1Name=${area1}&area2Name=${area2}&area3Name=${area3}"

            AsyncTaskHandleJson().execute(url)
        }

    }

    //
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

        var i = 0
        while (i < jsonList.length()) {
            val storeObject = JSONObject(jsonList[i].toString())
            Log.d(TAG, "$storeObject")
            val thumbnails = JSONArray(storeObject.getString("thumbnailUrls"))
            val thumbList: ArrayList<String> = ArrayList()
            var j = 0
            if (thumbnails.length() > 0)
                while (j < thumbnails.length()) {
                    thumbList.add(thumbnails[j].toString())
                    j++
                }
            else
                thumbList.add("https://icon-library.com/images/meal-icon-png/meal-icon-png-11.jpg")
            val a = storeObject.getString("description").replace(storeObject.getString("title"), "")
                .replace(storeObject.getString("category"), "")
                .replace(storeObject.getString("delievery"), "")
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

        val adapter = RecyclerViewAdapter(list, LayoutInflater.from(this@RecyclerView), width, this)
        recycler_View.adapter = adapter
        // 리니어레이아웃 매니저 사용
        recycler_View.layoutManager = LinearLayoutManager(this@RecyclerView)

        invisibleLoading()
    }

    // image show
    private fun imageShow() {
        Glide.with(this).load(R.drawable.loading_gif).into(image_view2)
    }

    private fun visibleLoading() {
        loadingLayout2.visibility = View.VISIBLE
    }

    private fun invisibleLoading() {
        loadingLayout2.visibility = View.INVISIBLE
    }

}

class RecyclerViewAdapter(
    var itemList: ArrayList<StoreClass>,
    private val inflater: LayoutInflater,
    private val width:Int,
    val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnails1:ImageView
        val thumbnails2 :ImageView
        val thumbnails3 :ImageView
        val title :TextView
        val delivery :TextView
        val star :TextView
        val category :TextView
        val visitor :TextView
        val blog :TextView
        val description :TextView
        init {
            thumbnails1 = itemView.findViewById(R.id.thumbnail1)
            thumbnails2 = itemView.findViewById(R.id.thumbnail2)
            thumbnails3 = itemView.findViewById(R.id.thumbnail3)
            title = itemView.findViewById(R.id.title)
            delivery = itemView.findViewById(R.id.delivery)
            star = itemView.findViewById(R.id.star)
            category = itemView.findViewById(R.id.category)
            visitor = itemView.findViewById(R.id.visitor)
            blog = itemView.findViewById(R.id.blog)
            description = itemView.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.thumbnails1.maxWidth = width / 3
//        holder.thumbnails2.maxWidth = width / 3
//        holder.thumbnails3.maxWidth = width / 3
//        holder.thumbnails1.maxHeight = width / 3 * 2 / 3
//        holder.thumbnails2.maxHeight = width / 3 * 2 / 3
//        holder.thumbnails3.maxHeight = width / 3 * 2 / 3

        val arrayThumbnail = itemList[position].thumbnailUrls
        val imageVIewArray = arrayOf(holder.thumbnails1, holder.thumbnails2, holder.thumbnails3)
        var i = 0
        arrayThumbnail!!.forEach { item ->
            Picasso.with(context)
                .load(arrayThumbnail!![i])
                .resize(width / 3, width / 3 * 2 / 3)
                .into(imageVIewArray[i])
            i++
        }

        holder.title.text = itemList[position].title
        holder.delivery.text = if (itemList[position].delievery.equals("")) "" else "배달"
        holder.star.setText(if (!itemList[position].star.equals("")) "★ ${itemList[position].star}" else "")
        holder.category.setText(if (!itemList[position].category.equals("")) itemList[position].category else "")
        holder.visitor.setText(if (!itemList[position].visitor.equals("")) itemList[position].visitor else "")
        holder.blog.setText(if (!itemList[position].blog.equals("")) itemList[position].blog else "")
        holder.description.setText(itemList[position].description)
    }

}