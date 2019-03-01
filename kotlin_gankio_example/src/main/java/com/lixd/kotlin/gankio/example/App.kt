package com.lixd.kotlin.gankio.example

import android.app.Application

class App : Application() {

    private lateinit var appComponent: AppComponent

    companion object {
        private lateinit var app: App

        fun getInstance(): App = app
    }


    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.builder().build()
    }

    fun getAppComponent(): AppComponent = appComponent
}