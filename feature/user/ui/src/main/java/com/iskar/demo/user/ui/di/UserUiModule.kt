package com.iskar.demo.user.ui.di

import com.iskar.demo.user.ui.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val userUiModule = module {

    viewModel { UserListViewModel(get(), get()) }

}
