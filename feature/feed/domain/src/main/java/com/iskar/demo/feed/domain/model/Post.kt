package com.iskar.demo.feed.domain.model

data class Post(
    val id: Long,
    val body: String,
    val title: String,
    val userId: Long,
)
