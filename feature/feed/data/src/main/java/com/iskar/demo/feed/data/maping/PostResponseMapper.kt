package com.iskar.demo.feed.data.maping

import com.iskar.demo.core.utils.SuspendableMapper
import com.iskar.demo.feed.data.network.response.PostResponse
import com.iskar.demo.feed.domain.model.Post

class PostResponseMapper : SuspendableMapper<PostResponse, Post> {
    override suspend fun map(input: PostResponse): Post = Post(
        id = input.id,
        body = input.body ?: "",
        title = input.title ?: "",
        userId = input.userId
    )
}
