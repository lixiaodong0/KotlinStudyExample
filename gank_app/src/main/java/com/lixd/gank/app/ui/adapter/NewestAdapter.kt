package com.lixd.gank.app.ui.adapter

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lixd.gank.app.R
import com.lixd.gank.app.data.NewestItem

class NewestAdapter(data: List<NewestItem>) : BaseMultiItemQuickAdapter<NewestItem, BaseViewHolder>(data) {

    init {
        addItemType(NewestItem.TEXT_TITLE, R.layout.item_newest_title_layout)
        addItemType(NewestItem.TEXT_DESC, R.layout.item_newest_desc_layout)
        addItemType(NewestItem.IMG_ICON, R.layout.item_newest_img_layout)
    }

    override fun convert(helper: BaseViewHolder, item: NewestItem) {
        when (item.type) {
            NewestItem.TEXT_TITLE ->
                helper.getView<TextView>(R.id.tv_title).setText(item.desc)
            NewestItem.TEXT_DESC -> {
                val sp = SpannableString(item.desc)
                val us = UnderlineSpan()
                sp.setSpan(us, 0, item.desc.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
                helper.getView<TextView>(R.id.tv_desc).setText(sp)
            }
            NewestItem.IMG_ICON ->
                Glide.with(mContext).load(item.url).into(helper.getView(R.id.img_welfare_icon))
        }
        helper.addOnClickListener(R.id.tv_desc)
    }
}