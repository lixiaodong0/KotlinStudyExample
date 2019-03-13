package com.lixd.gank.app.ui.fragment.welfare

import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.lixd.gank.app.data.GankType
import com.lixd.gank.app.inject.component.AppComponent
import com.lixd.gank.app.inject.component.DaggerWelfareFragmentComponent
import com.lixd.gank.app.inject.module.WelfareFragmentModule
import com.lixd.gank.app.inject.module.common.CommonPresenterModule
import com.lixd.gank.app.ui.activity.PhotoActivity
import com.lixd.gank.app.ui.fragment.CommonContract
import com.lixd.gank.app.ui.fragment.home.CommonFragment
import kotlinx.android.synthetic.main.fragment_common.*
import org.jetbrains.anko.support.v4.intentFor

class WelfareFragment : CommonFragment(), CommonContract.View, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {

    override fun getGankType(): GankType = GankType.Welfare

    override fun initRecyclerView() {
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        rvCommonList.layoutManager = layoutManager
        rvCommonList.adapter = mAdapter
        rvCommonList.itemAnimator = null
    }

    companion object {
        val TAG: String = WelfareFragment::class.java.simpleName
        fun newInstance(): Fragment = WelfareFragment()
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerWelfareFragmentComponent.builder()
                .appComponent(appComponent)
                .welfareFragmentModule(WelfareFragmentModule(mActivity!!))
                .commonPresenterModule(CommonPresenterModule(this))
                .build()
                .inject(this)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val data = mAdapter.getItem(position)
        startActivity(intentFor<PhotoActivity>("url" to data?.url))
    }
}