package com.iskar.demo.user.domain.interactor

import com.iskar.demo.user.domain.dataSource.UserDataSource
import com.iskar.demo.user.domain.model.User
import kotlinx.coroutines.flow.StateFlow

class UserInteractorImpl(
    private val sportDataSource: UserDataSource,
) : UserInteractor {
    override val userList: StateFlow<List<User>>
        get() = sportDataSource.userList

    override suspend fun fetchUserList() {
        sportDataSource.getUserList()
    }

}
