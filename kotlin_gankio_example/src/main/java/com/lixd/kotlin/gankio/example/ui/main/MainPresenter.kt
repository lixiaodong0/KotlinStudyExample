package com.lixd.kotlin.gankio.example.ui.main

import com.lixd.kotlin.gankio.example.data.source.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(val dataManager: DataManager, val mainView: IMainView) {

    fun getGankData() {
        dataManager.getGankData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe({ mainView.showLoading() })
                .doOnError({ mainView.stopLoading() })
                .subscribe({
                    mainView.stopLoading()
                    mainView.showGankData(it)
                })
    }
}