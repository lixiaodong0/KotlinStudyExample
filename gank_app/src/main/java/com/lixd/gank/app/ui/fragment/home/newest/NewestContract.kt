package com.lixd.gank.app.ui.fragment.home.newest

import com.lixd.gank.app.base.IBaseView
import com.lixd.gank.app.data.NewestItem

interface NewestContract {
    interface View : IBaseView {
        fun showTodayData(data: List<NewestItem>)
    }
    interface Presenter {
        fun getTodayData()
    }
}