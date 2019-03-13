package com.lixd.gank.app.data.source

import com.lixd.gank.app.config.MAX_SIZE
import com.lixd.gank.app.config.MIN_PAGE
import com.lixd.gank.app.data.GankItem
import io.reactivex.Observable

interface IDataSource {

    fun getData(type: String, size: Int = MAX_SIZE, page: Int = MIN_PAGE): Observable<List<GankItem>?>

    fun getTodayData(): Observable<LinkedHashMap<String, List<GankItem>?>>
}