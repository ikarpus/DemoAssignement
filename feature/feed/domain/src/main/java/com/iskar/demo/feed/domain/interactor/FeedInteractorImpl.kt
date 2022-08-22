package com.iskar.demo.feed.domain.interactor

import com.iskar.demo.feed.domain.dataSource.FeedDataSource
import com.iskar.demo.feed.domain.model.Post
import kotlinx.coroutines.flow.StateFlow

class FeedInteractorImpl(
    private val feedDataSource: FeedDataSource,
) : FeedInteractor {

    override val postList: StateFlow<List<Post>>
        get() = feedDataSource.postList

    override suspend fun fetchPostList() {
        feedDataSource.fetchPostList()
    }

}
