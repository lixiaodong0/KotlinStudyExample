package com.lixd.gank.app.api

import com.lixd.gank.app.config.MAX_SIZE
import com.lixd.gank.app.config.MIN_PAGE
import com.lixd.gank.app.data.GankResult
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     * 获取干货集中营 分类数据
     */
    @GET("api/data/{type}/{size}/{page}")
    fun getData(@Path("type") type: String,
                @Path("size") size: Int = MAX_SIZE,
                @Path("page") page: Int = MIN_PAGE): Observable<GankResult>


    /**
     * 获取干货集中营 今天更新的数据
     */
    @GET("api/today")
    fun getTodayData(): Observable<ResponseBody>
}