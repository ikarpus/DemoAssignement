package com.iskar.demo.feed.data.dataSource

import com.iskar.demo.core.utils.mapCatching
import com.iskar.demo.feed.data.maping.PostResponseMapper
import com.iskar.demo.feed.data.network.FeedApi
import com.iskar.demo.feed.domain.dataSource.FeedDataSource
import com.iskar.demo.feed.domain.model.Post
import kotlinx.coroutines.flow.MutableStateFlow

class FeedDataSourceImpl(
    private val api: FeedApi,
    private val postResponseMapper: PostResponseMapper,
) : FeedDataSource {

    override val postList = MutableStateFlow<List<Post>>(emptyList())

    override suspend fun fetchPostList() {
        postList.value = api.getPostList().mapCatching {
            postResponseMapper.map(it)
        }
    }
}
