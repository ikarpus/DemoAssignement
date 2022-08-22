package com.iskar.demo.feed.data.network.response


import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("body")
    val body: String?,
    @SerializedName("title")
    val title: String?,
)
