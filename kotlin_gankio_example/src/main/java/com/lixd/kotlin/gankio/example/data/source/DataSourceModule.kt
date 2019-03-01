package com.lixd.kotlin.gankio.example.data.source

import com.lixd.kotlin.gankio.example.api.GankIoService
import com.lixd.kotlin.gankio.example.config.BASE_URL
import com.lixd.kotlin.gankio.example.data.source.local.Local
import com.lixd.kotlin.gankio.example.data.source.local.LocalDataSource
import com.lixd.kotlin.gankio.example.data.source.remote.Remote
import com.lixd.kotlin.gankio.example.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun providerGankIoService(): GankIoService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GankIoService::class.java)

    @Singleton
    @Local
    @Provides
    fun providerLocalDataSource(): IDataSource = LocalDataSource()

    @Singleton
    @Remote
    @Provides
    fun providerRemoteDataSource(gankIoService: GankIoService): IDataSource = RemoteDataSource(gankIoService)

    @Singleton
    @Provides
    fun providerDataManager(@Local local: IDataSource, @Remote remote: IDataSource): DataManager = DataManager(local, remote)

}