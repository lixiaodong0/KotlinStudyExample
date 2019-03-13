package com.lixd.gank.app.ui.fragment

import com.lixd.gank.app.base.IBaseView
import com.lixd.gank.app.config.MAX_SIZE
import com.lixd.gank.app.config.MIN_PAGE
import com.lixd.gank.app.data.GankItem

interface CommonContract {

    interface View : IBaseView {
        fun showData(data: List<GankItem>?)
    }

    interface Presenter {
        fun getData(type: String, size: Int = MAX_SIZE, page: Int = MIN_PAGE)
    }
}