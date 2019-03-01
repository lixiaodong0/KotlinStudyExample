package com.lixd.kotlin.gankio.example.api

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

/**
 * Api地址 :
 *  https://gank.io/api
 */
interface GankIoService {
    @GET("api/today")
    fun getGankData() : Observable<ResponseBody>
}