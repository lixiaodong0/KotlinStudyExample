package com.lixd.kotlin.gankio.example

import com.lixd.kotlin.gankio.example.data.source.DataManager
import com.lixd.kotlin.gankio.example.data.source.DataSourceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent {
    fun getDataManager(): DataManager
}