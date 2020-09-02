package com.example.httprequestex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity

class ListAdapte (val context: Context, val list:ArrayList<StoreClass>):BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)

        val thumbnails1 = view.findViewById<ImageView>(R.id.thumbnail1)
        val thumbnails2 = view.findViewById<ImageView>(R.id.thumbnail2)
        val thumbnails3 = view.findViewById<ImageView>(R.id.thumbnail3)
        val title = view.findViewById<TextView>(R.id.title)
//        val area2Name = view.findViewById<TextView>(R.id.area2Name)
        val delivery = view.findViewById<TextView>(R.id.delivery)
        val star = view.findViewById<TextView>(R.id.star)
        val category = view.findViewById<TextView>(R.id.category)
        val visitor = view.findViewById<TextView>(R.id.visitor)
        val blog = view.findViewById<TextView>(R.id.blog)
        val description = view.findViewById<TextView>(R.id.description)

        thumbnails1.maxWidth = MainActivity.width/3
        thumbnails2.maxWidth = MainActivity.width/3
        thumbnails3.maxWidth = MainActivity.width/3
        thumbnails1.maxHeight = MainActivity.width/3*2/3
        thumbnails2.maxHeight = MainActivity.width/3*2/3
        thumbnails3.maxHeight = MainActivity.width/3*2/3

        val arrayThumbnail = list[position].thumbnailUrls
        val imageVIewArray = arrayOf(thumbnails1, thumbnails2, thumbnails3)
        var i = 0
        arrayThumbnail!!.forEach { item->
            Picasso.with(context)
                .load(arrayThumbnail!![i])
                .resize(MainActivity.width/3, MainActivity.width/3*2/3)
                .into(imageVIewArray[i])
            i++
        }

        title.text = list[position].title
//        area2Name.text = list[position].category
        delivery.text = if(list[position].delievery.equals("")) "" else "배달"
        star.setText(if(!list[position].star.equals("")) "★ ${list[position].star}" else "")
        category.setText(if(!list[position].category.equals("")) list[position].category else "")
        visitor.setText(if(!list[position].visitor.equals("")) list[position].visitor else "")
        blog.setText(if(!list[position].blog.equals("")) list[position].blog else "")
        description.setText(list[position].description)


        return view
    }

    override fun getItem(position: Int): Any ?{
        return list[position].title
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}