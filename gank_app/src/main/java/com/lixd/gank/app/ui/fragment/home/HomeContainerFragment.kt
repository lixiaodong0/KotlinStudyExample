package com.lixd.gank.app.ui.fragment.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import com.lixd.gank.app.R
import com.lixd.gank.app.base.BaseFragment
import com.lixd.gank.app.data.GankType
import com.lixd.gank.app.data.TabItem
import com.lixd.gank.app.ui.adapter.HomeContainerAdapter
import com.lixd.gank.app.ui.fragment.home.category.*
import com.lixd.gank.app.ui.fragment.home.newest.NewestFragment
import kotlinx.android.synthetic.main.fragment_home_container.*

class HomeContainerFragment : BaseFragment() {
    override fun getLayout(): Any = R.layout.fragment_home_container

    override fun init(rootView: View, savedInstanceState: Bundle?) {
        val data = arrayListOf<TabItem>()
        data.add(TabItem("今日干货", NewestFragment.newInstance()))
        data.add(TabItem(GankType.Android.type, AndroidFragment.newInstance()))
        data.add(TabItem(GankType.Ios.type, IosFragment.newInstance()))
        data.add(TabItem(GankType.App.type, AppFragment.newInstance()))
        data.add(TabItem(GankType.Web.type, WebFragment.newInstance()))
        data.add(TabItem(GankType.Extension.type, ExtensionFragment.newInstance()))
        data.add(TabItem(GankType.Recommend.type, RecommendFragment.newInstance()))
        data.add(TabItem(GankType.Video.type, VideoFragment.newInstance()))
        viewPager.adapter = HomeContainerAdapter(data, fragmentManager!!)
        viewPager.offscreenPageLimit = 3
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        val TAG: String = HomeContainerFragment::class.java.simpleName
        fun newInstance(): Fragment = HomeContainerFragment()
    }
}