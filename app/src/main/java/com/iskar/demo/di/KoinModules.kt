package com.iskar.demo.di

import com.iskar.demo.core.data.di.networkModule
import com.iskar.demo.feed.data.di.feedDataModule
import com.iskar.demo.feed.domain.di.feedDomainModule
import com.iskar.demo.feed.ui.di.feedUiModule
import com.iskar.demo.user.data.di.userDataModule
import com.iskar.demo.user.domain.di.userDomainModule
import com.iskar.demo.user.ui.di.userUiModule

object KoinModules {
    val modules = listOf(
        networkModule,
        userDataModule,
        userDomainModule,
        userUiModule,
        feedDataModule,
        feedDomainModule,
        feedUiModule,
    )
}
