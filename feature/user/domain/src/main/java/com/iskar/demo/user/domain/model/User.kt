package com.iskar.demo.user.domain.model

data class User(
    val userId: Long,
    val albumId: Long,
    val name: String,
    val thumbnailUrl: String?,
    val imageUrl: String?,
)
