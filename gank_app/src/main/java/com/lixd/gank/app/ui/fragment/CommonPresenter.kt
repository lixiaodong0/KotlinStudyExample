package com.lixd.gank.app.ui.fragment

import com.lixd.gank.app.base.BasePresenter
import com.lixd.gank.app.data.source.DataSourceManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CommonPresenter(val view: CommonContract.View, val dataSourceManager: DataSourceManager) : BasePresenter<CommonContract.View>(view), CommonContract.Presenter {

    override fun getData(type: String, size: Int, page: Int) {
        dataSourceManager.getData(type, size, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView?.showData(it)
                }, {
                    mView?.showToast("网络异常或其它原因导致错误~~~")
                })
    }
}