package com.lixd.gank.app.inject.module

import com.lixd.gank.app.api.ApiService
import com.lixd.gank.app.config.BASE_URL
import com.lixd.gank.app.data.source.DataSourceManager
import com.lixd.gank.app.data.source.IDataSource
import com.lixd.gank.app.data.source.local.LocalDataSource
import com.lixd.gank.app.data.source.remote.RemoteDataSource
import com.lixd.gank.app.inject.qualifier.Local
import com.lixd.gank.app.inject.qualifier.Remote
import com.lixd.gank.app.inject.scope.AppScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataSourceModule {

    @AppScope
    @Provides
    fun providerApiService(): ApiService = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiService::class.java)

    @Remote
    @AppScope
    @Provides
    fun providerRemoteDataSource(apiService: ApiService): IDataSource = RemoteDataSource(apiService)

    @Local
    @AppScope
    @Provides
    fun providerLocalDataSource(): IDataSource = LocalDataSource()

    @AppScope
    @Provides
    fun providerDataSourceManager(@Local local: IDataSource, @Remote remote: IDataSource): DataSourceManager = DataSourceManager(local, remote)

}