package com.lixd.gank.app.inject.component

import com.lixd.gank.app.inject.module.WelfareFragmentModule
import com.lixd.gank.app.inject.module.common.CommonPresenterModule
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.fragment.welfare.WelfareFragment
import dagger.Component

@FragmentScope
@Component(modules = arrayOf(WelfareFragmentModule::class, CommonPresenterModule::class), dependencies = arrayOf(AppComponent::class))
interface WelfareFragmentComponent {
    fun inject(welfareFragment: WelfareFragment)
}