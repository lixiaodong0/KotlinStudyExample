package com.lixd.kotlin.gankio.example.ui.main

import com.lixd.kotlin.gankio.example.AppComponent
import com.lixd.kotlin.gankio.example.ui.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}