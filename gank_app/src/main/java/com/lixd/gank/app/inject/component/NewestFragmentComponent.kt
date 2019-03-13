package com.lixd.gank.app.inject.component

import com.lixd.gank.app.inject.module.NewestFragmentModule
import com.lixd.gank.app.inject.scope.FragmentScope
import com.lixd.gank.app.ui.fragment.home.newest.NewestFragment
import dagger.Component

@FragmentScope
@Component(modules = arrayOf(NewestFragmentModule::class), dependencies = arrayOf(AppComponent::class))
interface NewestFragmentComponent {
    fun inject(newestFragment: NewestFragment)
}
