package com.lixd.kotlin.gankio.example.data.source

import com.lixd.kotlin.gankio.example.data.ProjectBean
import io.reactivex.Observable

interface IDataSource {
    fun getGankData(): Observable<List<ProjectBean>>
}