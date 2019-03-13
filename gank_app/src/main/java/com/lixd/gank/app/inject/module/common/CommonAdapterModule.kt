package com.lixd.gank.app.inject.module.common

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lixd.gank.app.data.GankItem
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.adapter.CommonAdapter
import com.lixd.gank.app.ui.fragment.CommonContract
import com.lixd.gank.app.ui.fragment.home.CommonFragment
import dagger.Module
import dagger.Provides

@Module
class CommonAdapterModule(val view: CommonContract.View) {
    @FragmentScope
    @Provides
    fun providerCommonAdapter(): BaseQuickAdapter<GankItem, BaseViewHolder> = CommonAdapter((view as CommonFragment).activity!!)
}