package com.lixd.kotlin.gankio.example.data.source

import com.lixd.kotlin.gankio.example.data.ProjectBean
import io.reactivex.Observable

class DataManager(private val local: IDataSource, private val remote: IDataSource) : IDataSource {

    override fun getGankData(): Observable<List<ProjectBean>> {
        return remote.getGankData().onErrorResumeNext(local.getGankData())
    }
}