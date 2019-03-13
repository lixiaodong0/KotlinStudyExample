package com.lixd.gank.app.data.source.local

import com.lixd.gank.app.data.GankItem
import com.lixd.gank.app.data.source.IDataSource
import io.reactivex.Observable

class LocalDataSource : IDataSource {
    override fun getTodayData(): Observable<LinkedHashMap<String, List<GankItem>?>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getData(type: String, size: Int, page: Int): io.reactivex.Observable<List<GankItem>?> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}