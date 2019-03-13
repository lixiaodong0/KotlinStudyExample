package com.lixd.gank.app.ui.adapter

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lixd.gank.app.R
import com.lixd.gank.app.data.GankItem

class WelfareAdapter(private val context: Context) : BaseQuickAdapter<GankItem, BaseViewHolder>(R.layout.item_welfare_list) {

    override fun convert(helper: BaseViewHolder?, item: GankItem?) {
        val imgWelfareIcon = helper!!.getView<ImageView>(R.id.img_welfare_icon)
        Glide.with(context).load(item?.url).into(imgWelfareIcon)
    }
}