package com.iskar.demo.user.ui

import com.iskar.demo.core.ui.base.BaseViewModel
import com.iskar.demo.feed.domain.interactor.FeedInteractor
import com.iskar.demo.navigation.args.FeedFragmentParams
import com.iskar.demo.user.domain.interactor.UserInteractor
import com.iskar.demo.user.ui.list.mapping.toUserItem
import com.iskar.demo.user.ui.list.models.UserItem
import kotlinx.coroutines.flow.*

class UserListViewModel(
    private val userInteractor: UserInteractor,
    private val feedInteractor: FeedInteractor,
) : BaseViewModel() {

    val userListFlow: Flow<List<UserItem>> = combine(
        feedInteractor.postList,
        userInteractor.userList
    ) { posts, users ->
        if (posts.isEmpty()) return@combine emptyList()
        users.map { user ->
            val postCount = posts.filter { post ->
                post.userId == user.userId
            }.size
            user.toUserItem(postCount)
        }
    }
        .flowOn(ioContext)

    val navigateFeed: SharedFlow<FeedFragmentParams> = MutableSharedFlow(extraBufferCapacity = 1)

    init {
        updateUserList()
    }

    fun updateUserList() {
        launch(dispatcher = ioContext) {
            feedInteractor.fetchPostList()
            userInteractor.fetchUserList()
        }
    }

    fun navigateFeed(userId: Long) {
        navigateFeed.tryEmit(
            FeedFragmentParams(
                userId = userId,
                imageUrl = userInteractor.userList.value.firstOrNull { it.userId == userId }?.imageUrl
            )
        )
    }

}
