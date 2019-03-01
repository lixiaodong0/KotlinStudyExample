package com.lixd.kotlin.gankio.example.ui.main

import com.lixd.kotlin.gankio.example.data.source.DataManager
import com.lixd.kotlin.gankio.example.ui.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val context: MainActivity) {

    @ActivityScope
    @Provides
    fun providerMainAdapter(): MainAdapter = MainAdapter(context, arrayListOf())

    @ActivityScope
    @Provides
    fun providerMainPresenter(dataManager: DataManager): MainPresenter = MainPresenter(dataManager, context)

}