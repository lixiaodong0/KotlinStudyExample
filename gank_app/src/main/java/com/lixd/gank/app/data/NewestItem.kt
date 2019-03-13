package com.lixd.gank.app.data

import com.chad.library.adapter.base.entity.MultiItemEntity

data class NewestItem(val type: Int, val desc: String, val url: String?) : MultiItemEntity {


    companion object {
        const val TEXT_TITLE: Int = 1
        const val TEXT_DESC: Int = 2
        const val IMG_ICON: Int = 3

        fun createTextItem(desc: String, url: String?): NewestItem = NewestItem(TEXT_TITLE, desc, url)
        fun createDescItem(desc: String, url: String?): NewestItem = NewestItem(TEXT_DESC, desc, url)
        fun createImgItem(desc: String, url: String?): NewestItem = NewestItem(IMG_ICON, desc, url)
    }

    override fun getItemType(): Int = type

}
