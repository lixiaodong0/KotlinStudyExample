package com.lixd.gank.app.ui.activity

import android.os.Bundle
import com.bumptech.glide.Glide
import com.lixd.gank.app.R
import com.lixd.gank.app.base.BaseActivity
import kotlinx.android.synthetic.main.activity_photo.*

class PhotoActivity : BaseActivity() {
    override fun init(savedInstanceState: Bundle?) {
        val url = intent.getStringExtra("url")
        Glide.with(this).load(url).into(photoView)
    }

    override fun getLayout(): Any = R.layout.activity_photo
}
