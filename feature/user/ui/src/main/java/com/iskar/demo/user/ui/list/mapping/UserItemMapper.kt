package com.iskar.demo.user.ui.list.mapping

import com.iskar.demo.user.domain.model.User
import com.iskar.demo.user.ui.list.models.UserItem

fun User.toUserItem(postCount: Int) = UserItem(
    id = userId,
    name = name,
    thumbnailUrl = thumbnailUrl,
    postCount = postCount,
)
