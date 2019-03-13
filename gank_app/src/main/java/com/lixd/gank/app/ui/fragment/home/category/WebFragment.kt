package com.lixd.gank.app.ui.fragment.home.category

import android.support.v4.app.Fragment
import com.lixd.gank.app.data.GankType
import com.lixd.gank.app.ui.fragment.home.CommonFragment

class WebFragment : CommonFragment() {
    override fun getGankType(): GankType = GankType.Web

    companion object {
        fun newInstance(): Fragment = WebFragment()
    }
}