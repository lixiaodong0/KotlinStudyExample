package com.lixd.gank.app.base

open class BasePresenter<V>(view: V) : IBasePresenter<V> {

    protected var mView: V? = null

    init {
        attachView(view)
    }

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        if (mView != null) {
            mView = null
        }
    }
}