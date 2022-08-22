package com.iskar.demo.feed.domain.dataSource

import com.iskar.demo.feed.domain.model.Post
import kotlinx.coroutines.flow.StateFlow

interface FeedDataSource {

    val postList: StateFlow<List<Post>>

    suspend fun fetchPostList()

}
