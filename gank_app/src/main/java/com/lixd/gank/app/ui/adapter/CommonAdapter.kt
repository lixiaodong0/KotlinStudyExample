package com.lixd.gank.app.ui.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lixd.gank.app.R
import com.lixd.gank.app.data.GankItem

class CommonAdapter(val context: Context) : BaseQuickAdapter<GankItem, BaseViewHolder>(R.layout.item_cateory_list) {
    override fun convert(helper: BaseViewHolder, item: GankItem) {
        val imgWriterIcon = helper.getView<ImageView>(R.id.img_writer_icon)
        val imgArticleIcon = helper.getView<ImageView>(R.id.img_article_icon)
        val tvWriterName = helper.getView<TextView>(R.id.tv_writer_name)
        val tvArticleTitle = helper.getView<TextView>(R.id.tv_article_title)
        val tvArticlePushDate = helper.getView<TextView>(R.id.tv_articla_push_date)

        tvWriterName.setText(item.who)
        tvArticleTitle.setText(item.desc)
        tvArticlePushDate.setText(item.publishedAt)
        if (item.images != null && item.images.size > 0) {
            Glide.with(context).load(item.images[0]).into(imgArticleIcon)
            imgArticleIcon.visibility = View.VISIBLE
        } else {
            imgArticleIcon.visibility = View.GONE
        }
    }
}