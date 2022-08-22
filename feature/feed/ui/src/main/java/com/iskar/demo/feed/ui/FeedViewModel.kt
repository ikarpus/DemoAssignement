package com.iskar.demo.feed.ui

import com.iskar.demo.core.ui.base.BaseViewModel
import com.iskar.demo.feed.domain.interactor.FeedInteractor
import com.iskar.demo.feed.ui.list.mapping.PostItemMapper
import com.iskar.demo.feed.ui.list.models.FeedItem
import com.iskar.demo.feed.ui.list.models.HeaderItem
import com.iskar.demo.navigation.args.FeedFragmentParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FeedViewModel(
    private val params: FeedFragmentParams,
    private val feedInteractor: FeedInteractor,
    private val postItemMapper: PostItemMapper,
) : BaseViewModel() {

    val feed: Flow<List<FeedItem>> = feedInteractor.postList.map {
        val list = mutableListOf<FeedItem>()
        list.add(HeaderItem(id = params.userId, imageUrl = params.imageUrl))
        list.addAll(postItemMapper.map(it.filter { post -> post.userId == params.userId }))
        list
    }

    init {
        updateFeed()
    }

    fun updateFeed() {
        launch(dispatcher = ioContext) {
            feedInteractor.fetchPostList()
        }
    }

}
