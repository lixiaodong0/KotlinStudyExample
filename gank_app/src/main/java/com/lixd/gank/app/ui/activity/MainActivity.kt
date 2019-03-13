package com.lixd.gank.app.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.lixd.gank.app.R
import com.lixd.gank.app.base.BaseActivity
import com.lixd.gank.app.ui.fragment.about.AboutFragment
import com.lixd.gank.app.ui.fragment.home.HomeContainerFragment
import com.lixd.gank.app.ui.fragment.welfare.WelfareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var mCurrentFragment: Fragment? = null

    private var mLastFragment: Fragment? = null

    override fun getLayout(): Any = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        initBottomTabView()
    }

    private fun initBottomTabView() {
        bottomNavigationView.selectedItemId = R.id.tab_home
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        changeTab(HomeContainerFragment.TAG)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.tab_home -> changeTab(HomeContainerFragment.TAG)
            R.id.tab_welfare -> changeTab(WelfareFragment.TAG)
            R.id.tab_about -> changeTab(AboutFragment.TAG)
        }
        return true
    }

    private fun changeTab(tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            when (tag) {
                HomeContainerFragment.TAG -> mCurrentFragment = HomeContainerFragment.newInstance()
                WelfareFragment.TAG -> mCurrentFragment = WelfareFragment.newInstance()
                AboutFragment.TAG -> mCurrentFragment = AboutFragment.newInstance()
                else -> throw RuntimeException("Fragment类型错误")
            }
            transaction.add(R.id.container, mCurrentFragment!!, tag)
        } else {
            mCurrentFragment = supportFragmentManager.findFragmentByTag(tag)!!
        }
        if (mLastFragment != null) {
            transaction.hide(mLastFragment!!)
        }
        transaction.show(mCurrentFragment!!)
        transaction.commit()
        mLastFragment = mCurrentFragment
    }
}
