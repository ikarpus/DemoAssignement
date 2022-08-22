package com.iskar.demo.user.domain.dataSource

import com.iskar.demo.user.domain.model.User
import kotlinx.coroutines.flow.StateFlow

interface UserDataSource {

    val userList: StateFlow<List<User>>

    suspend fun getUserList()

}
