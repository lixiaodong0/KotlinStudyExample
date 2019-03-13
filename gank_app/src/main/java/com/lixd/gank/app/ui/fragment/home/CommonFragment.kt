package com.lixd.gank.app.ui.fragment.home

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lixd.gank.app.R
import com.lixd.gank.app.base.BaseFragment
import com.lixd.gank.app.config.MIN_PAGE
import com.lixd.gank.app.data.GankItem
import com.lixd.gank.app.data.GankType
import com.lixd.gank.app.inject.component.AppComponent
import com.lixd.gank.app.inject.component.DaggerCommonFragmentComponent
import com.lixd.gank.app.inject.module.common.CommonAdapterModule
import com.lixd.gank.app.inject.module.common.CommonPresenterModule
import com.lixd.gank.app.ui.activity.DetailActivity
import com.lixd.gank.app.ui.fragment.CommonContract
import kotlinx.android.synthetic.main.fragment_common.*
import org.jetbrains.anko.support.v4.intentFor
import javax.inject.Inject

abstract class CommonFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, CommonContract.View, BaseQuickAdapter.OnItemClickListener {


    @Inject
    lateinit var mAdapter: BaseQuickAdapter<GankItem, BaseViewHolder>

    @Inject
    lateinit var mPresenter: CommonContract.Presenter

    //当前页数
    private var mCurrentPage: Int = MIN_PAGE
    //加载更多状态标识符
    private var isLoadMore: Boolean = false
    //刷新状态标识符
    private var isRefresh: Boolean = false


    override fun getLayout(): Any = R.layout.fragment_common

    override fun init(rootView: View, savedInstanceState: Bundle?) {
        initRefreshLayout()
        initRecyclerView()
        initAdapter()
        refreshLayout.post {
            refreshLayout.isRefreshing = true
            onRefresh()
        }
    }

    open fun initRefreshLayout() {
        refreshLayout.setOnRefreshListener(this)
    }

    open fun initRecyclerView() {
        rvCommonList.layoutManager = LinearLayoutManager(mActivity)
        rvCommonList.adapter = mAdapter
    }

    open fun initAdapter() {
        mAdapter.setOnLoadMoreListener(this, rvCommonList)
        mAdapter.disableLoadMoreIfNotFullPage()
        mAdapter.setOnItemClickListener(this)
    }

     override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        val data = mAdapter.getItem(position)
        startActivity(intentFor<DetailActivity>("url" to data?.url))
    }

    /**
     * 下拉刷新回调
     */
    override fun onRefresh() {
        isRefresh = true
        isLoadMore = false
        mCurrentPage = MIN_PAGE
        mPresenter.getData(getGankType().type, page = mCurrentPage)
    }

    /**
     * 上拉加载更多回调
     */
    override fun onLoadMoreRequested() {
        isLoadMore = true
        isRefresh = false
        mCurrentPage++
        mPresenter.getData(getGankType().type, page = mCurrentPage)
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerCommonFragmentComponent.builder()
                .appComponent(appComponent)
                .commonAdapterModule(CommonAdapterModule(this))
                .commonPresenterModule(CommonPresenterModule(this))
                .build()
                .inject(this)
    }

    override fun showData(data: List<GankItem>?) {
        if (isRefresh) {
            mAdapter.setNewData(data)
            //完成刷新操作
            refreshLayout.isRefreshing = false
        } else if (isLoadMore) {
            if (data != null && !data.isEmpty()) {
                mAdapter.addData(data!!)
                //完成加载更多操作
                mAdapter.loadMoreComplete()
            }
        }
    }

    abstract fun getGankType(): GankType
}