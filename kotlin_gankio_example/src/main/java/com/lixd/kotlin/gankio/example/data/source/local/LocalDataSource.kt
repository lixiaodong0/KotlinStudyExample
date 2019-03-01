package com.lixd.kotlin.gankio.example.data.source.local

import com.lixd.kotlin.gankio.example.data.ProjectBean
import com.lixd.kotlin.gankio.example.data.source.IDataSource
import io.reactivex.Observable

class LocalDataSource : IDataSource{
    override fun getGankData(): Observable<List<ProjectBean>> {
       return Observable.just(arrayListOf())
    }
}