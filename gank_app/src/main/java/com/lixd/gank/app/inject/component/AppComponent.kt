package com.lixd.gank.app.inject.component

import com.lixd.gank.app.data.source.DataSourceManager
import com.lixd.gank.app.inject.module.DataSourceModule
import com.lixd.gank.app.inject.scope.AppScope
import dagger.Component


@AppScope
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent {

    fun getDataSourceManager(): DataSourceManager
}