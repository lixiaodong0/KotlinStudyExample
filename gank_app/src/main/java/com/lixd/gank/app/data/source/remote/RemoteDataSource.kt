package com.lixd.gank.app.data.source.remote

import com.lixd.gank.app.api.ApiService
import com.lixd.gank.app.data.GankItem
import com.lixd.gank.app.data.source.IDataSource
import com.lixd.gank.app.util.GankUtil
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class RemoteDataSource(val apiService: ApiService) : IDataSource {
    override fun getTodayData(): Observable<LinkedHashMap<String, List<GankItem>?>> {
        return apiService.getTodayData()
                .subscribeOn(Schedulers.io())
                .flatMap {
                    Observable.just(GankUtil.parseTodayData(it.string()))
                }

    }

    override fun getData(type: String, size: Int, page: Int): Observable<List<GankItem>?> {
        return apiService.getData(type, size, page)
                .subscribeOn(Schedulers.io())
                .flatMap {
                    Observable.just(it.results)
                }
    }
}