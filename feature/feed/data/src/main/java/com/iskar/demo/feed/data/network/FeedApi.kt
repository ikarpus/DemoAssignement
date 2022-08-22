package com.iskar.demo.feed.data.network

import com.iskar.demo.feed.data.network.response.PostResponse
import retrofit2.http.GET

interface FeedApi {

    @GET("SharminSirajudeen/test_resources/posts")
    suspend fun getPostList(): List<PostResponse>
}
