package com.lixd.gank.app.ui.fragment.home.newest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.lixd.gank.app.R
import com.lixd.gank.app.base.BaseFragment
import com.lixd.gank.app.data.NewestItem
import com.lixd.gank.app.inject.component.AppComponent
import com.lixd.gank.app.inject.component.DaggerNewestFragmentComponent
import com.lixd.gank.app.inject.module.NewestFragmentModule
import com.lixd.gank.app.ui.activity.DetailActivity
import com.lixd.gank.app.ui.adapter.NewestAdapter
import kotlinx.android.synthetic.main.fragment_newest.*
import org.jetbrains.anko.support.v4.intentFor
import javax.inject.Inject

class NewestFragment : BaseFragment(), NewestContract.View, BaseQuickAdapter.OnItemChildClickListener {

    @Inject
    lateinit var mAdapter: NewestAdapter
    @Inject
    lateinit var mPresenter: NewestContract.Presenter

    override fun getLayout(): Any = R.layout.fragment_newest

    companion object {
        fun newInstance(): Fragment = NewestFragment()
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val url = mAdapter.getItem(position)?.url
        startActivity(intentFor<DetailActivity>("url" to url))
    }

    override fun init(rootView: View, savedInstanceState: Bundle?) {
        refreshLayout.post {
            refreshLayout.isRefreshing = true
        }
        recyclerView.layoutManager = LinearLayoutManager(mActivity)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = mAdapter
        mAdapter.setOnItemChildClickListener(this)
        mPresenter.getTodayData()
    }

    override fun showTodayData(data: List<NewestItem>) {
        mAdapter.setNewData(data)
        refreshLayout.isRefreshing = false
        refreshLayout.isEnabled = false
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerNewestFragmentComponent.builder()
                .appComponent(appComponent)
                .newestFragmentModule(NewestFragmentModule(this, arrayListOf()))
                .build()
                .inject(this)
    }
}