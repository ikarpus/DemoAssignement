package com.iskar.demo.user.data.dataSource

import com.iskar.demo.core.utils.mapCatching
import com.iskar.demo.user.data.maping.UserResponseMapper
import com.iskar.demo.user.data.network.UserApi
import com.iskar.demo.user.domain.dataSource.UserDataSource
import com.iskar.demo.user.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow

class UserDataSourceImpl(
    private val api: UserApi,
    private val userResponseMapper: UserResponseMapper,
) : UserDataSource {

    override val userList = MutableStateFlow<List<User>>(emptyList())

    override suspend fun getUserList() {
        userList.value = api.getUserList().mapCatching {
            userResponseMapper.map(it)
        }
    }
}
