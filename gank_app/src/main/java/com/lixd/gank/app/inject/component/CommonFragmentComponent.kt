package com.lixd.gank.app.inject.component

import com.lixd.gank.app.inject.module.common.CommonAdapterModule
import com.lixd.gank.app.inject.module.common.CommonPresenterModule
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.fragment.home.CommonFragment
import dagger.Component

@FragmentScope
@Component(modules = arrayOf(CommonPresenterModule::class,CommonAdapterModule::class), dependencies = arrayOf(AppComponent::class))
interface CommonFragmentComponent {
    fun inject(fragment: CommonFragment)
}