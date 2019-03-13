package com.lixd.gank.app.ui.fragment.home.category

import android.support.v4.app.Fragment
import com.lixd.gank.app.data.GankType
import com.lixd.gank.app.ui.fragment.home.CommonFragment

class AppFragment : CommonFragment() {
    override fun getGankType(): GankType = GankType.App

    companion object {
        fun newInstance(): Fragment = AppFragment()
    }
}