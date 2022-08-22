package com.iskar.demo.user.domain.di

import com.iskar.demo.user.domain.interactor.UserInteractor
import com.iskar.demo.user.domain.interactor.UserInteractorImpl
import org.koin.dsl.module

val userDomainModule = module {

    factory<UserInteractor> { UserInteractorImpl(get()) }
}
