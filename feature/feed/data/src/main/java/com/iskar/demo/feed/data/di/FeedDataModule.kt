package com.iskar.demo.feed.data.di

import com.iskar.demo.feed.data.dataSource.FeedDataSourceImpl
import com.iskar.demo.feed.data.maping.PostResponseMapper
import com.iskar.demo.feed.data.network.FeedApi
import com.iskar.demo.feed.domain.dataSource.FeedDataSource
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val feedDataModule = module {

    single<FeedDataSource> { FeedDataSourceImpl(get(), get()) }

    single {
        (get() as Retrofit).create(FeedApi::class.java)
    }

    factory { PostResponseMapper() } bind PostResponseMapper::class
}
