package com.lixd.kotlin.gankio.example.ui.main

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.lixd.kotlin.gankio.example.R
import com.lixd.kotlin.gankio.example.data.ProjectBean
import org.jetbrains.anko.find

class MainAdapter(private val context: Context, private var datas: List<ProjectBean>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(viewGroup: ViewGroup, itemType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_main_list, viewGroup, false);
        return MainViewHolder(itemView)
    }

    override fun getItemCount(): Int = if (datas != null) datas.size else 0

    override fun onBindViewHolder(viewholder: MainViewHolder, position: Int) {
        val projectBean = datas[position]
        viewholder.tvTitle.setText(projectBean.desc)
        viewholder.tvWriter.setText(projectBean.who)
        viewholder.tvDate.setText(projectBean.publishedAt)
        viewholder.tvTag.setText(projectBean.type)
        if (projectBean.images != null) {
            viewholder.rvImageList.visibility = View.VISIBLE
            viewholder.rvImageList.layoutManager = GridLayoutManager(context, 3)
            viewholder.rvImageList.adapter = ImageAdapter(context, projectBean.images)
        } else {
            viewholder.rvImageList.visibility = View.GONE
        }
        viewholder.itemView.setOnClickListener { onItemClickListener?.onClick(position, projectBean) }
    }


    fun setNewData(newData: List<ProjectBean>) {
        datas = newData
        notifyDataSetChanged()
    }

    fun addData(newData: List<ProjectBean>) {
        if (newData != null && newData.size > 0) {
            (datas as ArrayList<ProjectBean>).addAll(newData)
            notifyDataSetChanged()
        }
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.find(R.id.tvTitle)
        val tvWriter: TextView = itemView.find(R.id.tvWriter)
        val tvDate: TextView = itemView.find(R.id.tvDate)
        val tvTag: TextView = itemView.find(R.id.tvTag)
        val rvImageList: RecyclerView = itemView.find(R.id.rvImageList)
    }


    interface OnItemClickListener {
        fun onClick(position: Int, data: ProjectBean)
    }
}