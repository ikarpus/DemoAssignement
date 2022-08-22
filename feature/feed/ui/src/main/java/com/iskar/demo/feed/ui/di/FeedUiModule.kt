package com.iskar.demo.feed.ui.di

import com.iskar.demo.feed.ui.FeedViewModel
import com.iskar.demo.feed.ui.list.mapping.PostItemMapper
import com.iskar.demo.navigation.args.FeedFragmentParams
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val feedUiModule = module {

    viewModel { (params: FeedFragmentParams) -> FeedViewModel(params, get(), get()) }

    single { PostItemMapper() }

}
