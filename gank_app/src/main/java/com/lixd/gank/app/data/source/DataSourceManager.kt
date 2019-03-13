package com.lixd.gank.app.data.source

import com.lixd.gank.app.data.GankItem
import io.reactivex.Observable

class DataSourceManager(private val local: IDataSource?, private val remote: IDataSource) : IDataSource {
    override fun getTodayData(): Observable<LinkedHashMap<String, List<GankItem>?>> {
        return remote.getTodayData()
    }

    override fun getData(type: String, size: Int, page: Int): Observable<List<GankItem>?> {
        return remote.getData(type, size, page)
    }
}
