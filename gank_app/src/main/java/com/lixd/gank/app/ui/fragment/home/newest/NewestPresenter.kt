package com.lixd.gank.app.ui.fragment.home.newest

import com.lixd.gank.app.base.BasePresenter
import com.lixd.gank.app.data.GankType
import com.lixd.gank.app.data.NewestItem
import com.lixd.gank.app.data.source.DataSourceManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewestPresenter(view: NewestContract.View, val dataSourceManager: DataSourceManager) : BasePresenter<NewestContract.View>(view), NewestContract.Presenter {
    override fun getTodayData() {
        dataSourceManager.getTodayData()
                .subscribeOn(Schedulers.io())
                .flatMap {
                    val datas = arrayListOf<NewestItem>()
                    for ((key, vaule) in it) {
                        if (GankType.Welfare.type.equals(key)) {
                            if (vaule != null && vaule.size > 0) {
                                datas.add(0, NewestItem.createImgItem("", vaule[0].url))
                            }
                        } else {
                            datas.add(NewestItem.createTextItem(key, null))
                            vaule?.forEach {
                                datas.add(NewestItem.createDescItem(it.desc, it.url))
                            }
                        }
                    }
                    Observable.just(datas)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mView?.showTodayData(it)
                }, {
                    mView?.showToast("网络异常或者出现未知错误~~~")
                })
    }
}