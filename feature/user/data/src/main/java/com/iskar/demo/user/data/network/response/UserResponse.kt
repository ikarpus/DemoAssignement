package com.iskar.demo.user.data.network.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("userId")
    val userId: Long,
    @SerializedName("albumId")
    val albumId: Long,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val imageUrl: String?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?,
)
