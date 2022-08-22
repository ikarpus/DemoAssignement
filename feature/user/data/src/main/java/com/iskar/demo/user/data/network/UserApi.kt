package com.iskar.demo.user.data.network

import com.iskar.demo.user.data.network.response.UserResponse
import retrofit2.http.GET

interface UserApi {

    @GET("SharminSirajudeen/test_resources/users")
    suspend fun getUserList(): List<UserResponse>
}
