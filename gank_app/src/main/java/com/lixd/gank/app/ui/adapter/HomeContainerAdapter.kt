package com.lixd.gank.app.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.lixd.gank.app.data.TabItem

class HomeContainerAdapter(val data: List<TabItem>, val manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
    override fun getCount(): Int = data.size
    override fun getItem(position: Int): Fragment = data[position].fragment
    override fun getPageTitle(position: Int): CharSequence? = data[position].title
}