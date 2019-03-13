package com.lixd.gank.app.inject.module.common

import com.lixd.gank.app.data.source.DataSourceManager
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.fragment.CommonContract
import com.lixd.gank.app.ui.fragment.CommonPresenter
import dagger.Module
import dagger.Provides

@Module
class CommonPresenterModule(val view: CommonContract.View) {
    @FragmentScope
    @Provides
    fun providerCommonPresenter(dataSourceManager: DataSourceManager): CommonContract.Presenter = CommonPresenter(view, dataSourceManager)
}