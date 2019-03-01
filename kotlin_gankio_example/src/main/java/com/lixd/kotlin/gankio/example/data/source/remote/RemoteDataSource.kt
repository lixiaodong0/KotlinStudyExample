package com.lixd.kotlin.gankio.example.data.source.remote

import com.lixd.kotlin.gankio.example.api.GankIoService
import com.lixd.kotlin.gankio.example.data.ProjectBean
import com.lixd.kotlin.gankio.example.data.source.IDataSource
import com.lixd.kotlin.gankio.example.utils.GankUtil
import io.reactivex.Observable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

class RemoteDataSource(private val gankIoService: GankIoService) : IDataSource {
    override fun getGankData(): Observable<List<ProjectBean>> {
        return gankIoService.getGankData()
                .flatMap(object : Function<ResponseBody, Observable<List<ProjectBean>>> {
                    override fun apply(response: ResponseBody): Observable<List<ProjectBean>> {
                        val jsonResponse = response.string()
                        return Observable.just(GankUtil.formatGankData(jsonResponse))
                    }
                })
                .subscribeOn(Schedulers.io())
    }

}