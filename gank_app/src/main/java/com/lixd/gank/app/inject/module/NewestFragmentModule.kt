package com.lixd.gank.app.inject.module

import com.lixd.gank.app.data.NewestItem
import com.lixd.gank.app.data.source.DataSourceManager
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.adapter.NewestAdapter
import com.lixd.gank.app.ui.fragment.home.newest.NewestContract
import com.lixd.gank.app.ui.fragment.home.newest.NewestPresenter
import dagger.Module
import dagger.Provides

@Module
class NewestFragmentModule(val view: NewestContract.View, val data: List<NewestItem>) {

    @Provides
    @FragmentScope
    fun providerNewestAdapter(): NewestAdapter = NewestAdapter(data)

    @Provides
    @FragmentScope
    fun providerNewestPresenter(dataSourceManager: DataSourceManager): NewestContract.Presenter = NewestPresenter(view, dataSourceManager)
}