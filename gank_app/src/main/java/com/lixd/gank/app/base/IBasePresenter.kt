package com.lixd.gank.app.base

interface IBasePresenter<V> {

    fun attachView(view: V)

    fun detachView()
}
