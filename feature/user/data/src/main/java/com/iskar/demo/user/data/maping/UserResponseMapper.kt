package com.iskar.demo.user.data.maping

import com.iskar.demo.core.utils.SuspendableMapper
import com.iskar.demo.user.data.network.response.UserResponse
import com.iskar.demo.user.domain.model.User

class UserResponseMapper : SuspendableMapper<UserResponse, User> {
    override suspend fun map(input: UserResponse): User = User(
        userId = input.userId,
        albumId = input.albumId,
        name = input.name ?: "",
        thumbnailUrl = input.thumbnailUrl,
        imageUrl = input.imageUrl,
    )
}
