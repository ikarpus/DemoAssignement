package com.iskar.demo.feed.domain.interactor

import com.iskar.demo.feed.domain.model.Post
import kotlinx.coroutines.flow.StateFlow

interface FeedInteractor {

    val postList: StateFlow<List<Post>>

    suspend fun fetchPostList()

}
