package com.iskar.demo.feed.ui.list.mapping

import com.iskar.demo.core.utils.SuspendableMapper
import com.iskar.demo.feed.domain.model.Post
import com.iskar.demo.feed.ui.list.models.PostItem

class PostItemMapper : SuspendableMapper<List<Post>, List<PostItem>> {
    override suspend fun map(input: List<Post>): List<PostItem> = input.map {
        PostItem(
            id = it.id,
            title = it.title,
            body = it.body,
        )
    }
}
