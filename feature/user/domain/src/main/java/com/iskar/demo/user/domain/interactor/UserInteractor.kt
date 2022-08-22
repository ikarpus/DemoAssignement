package com.iskar.demo.user.domain.interactor

import com.iskar.demo.user.domain.model.User
import kotlinx.coroutines.flow.StateFlow

interface UserInteractor {

    val userList: StateFlow<List<User>>

    suspend fun fetchUserList()

}
