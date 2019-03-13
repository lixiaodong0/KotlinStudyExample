package com.lixd.gank.app.inject.module

import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lixd.gank.app.data.GankItem
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.adapter.WelfareAdapter
import dagger.Module
import dagger.Provides

@Module
class WelfareFragmentModule(val context: Context) {

    @FragmentScope
    @Provides
    fun providerWelfareAdapter(): BaseQuickAdapter<GankItem, BaseViewHolder> = WelfareAdapter(context)
}