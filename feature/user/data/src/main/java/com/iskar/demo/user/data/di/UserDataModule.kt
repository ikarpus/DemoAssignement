package com.iskar.demo.user.data.di

import com.iskar.demo.user.data.dataSource.UserDataSourceImpl
import com.iskar.demo.user.data.maping.UserResponseMapper
import com.iskar.demo.user.data.network.UserApi
import com.iskar.demo.user.domain.dataSource.UserDataSource
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val userDataModule = module {

    single<UserDataSource> { UserDataSourceImpl(get(), get()) }

    single {
        (get() as Retrofit).create(UserApi::class.java)
    }

    factory { UserResponseMapper() } bind UserResponseMapper::class
}
