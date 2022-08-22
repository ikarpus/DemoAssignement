package com.iskar.demo.feed.domain.di

import com.iskar.demo.feed.domain.interactor.FeedInteractor
import com.iskar.demo.feed.domain.interactor.FeedInteractorImpl
import org.koin.dsl.module

val feedDomainModule = module {

    factory<FeedInteractor> { FeedInteractorImpl(get()) }
}
