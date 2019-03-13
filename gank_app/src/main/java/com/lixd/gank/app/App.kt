package com.lixd.gank.app

import android.app.Application
import com.lixd.gank.app.inject.component.AppComponent
import com.lixd.gank.app.inject.component.DaggerAppComponent
import com.lixd.gank.app.inject.module.DataSourceModule

class App : Application() {

    private lateinit var appComponent: AppComponent

    companion object {
        private lateinit var INSTANCE: App


        fun getInstance() = INSTANCE
    }


    override fun onCreate() {
        super.onCreate()

        INSTANCE = this


        appComponent = DaggerAppComponent.builder()
                .dataSourceModule(DataSourceModule())
                .build()
    }

    fun getAppComponent(): AppComponent = appComponent
}