package com.lixd.kotlin.gankio.example.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.lixd.kotlin.gankio.example.R
import org.jetbrains.anko.find

class ImageAdapter(val context: Context, var datas: List<String>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_image_list, p0, false);
        return ImageViewHolder(itemView)
    }

    override fun getItemCount(): Int = if (datas != null) datas.size else 0
    override fun onBindViewHolder(viewHolder: ImageViewHolder, position: Int) {
        Glide.with(context).load(datas[position]).into(viewHolder.imgIcon)
    }


    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIcon: ImageView = itemView.find(R.id.imgIcon)
    }
}