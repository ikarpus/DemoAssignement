package com.iskar.demo.user.ui

import android.os.Bundle
import android.view.View
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.iskar.demo.core.ui.base.BaseFragment
import com.iskar.demo.core.ui.ext.subscribe
import com.iskar.demo.core.ui.list.DefaultIdItemDiffCallback
import com.iskar.demo.core.ui.list.DefaultItemDecoration
import com.iskar.demo.feature.user.ui.R
import com.iskar.demo.feature.user.ui.databinding.UserFragmentUserBinding
import com.iskar.demo.user.ui.list.models.UserItem

class UserListFragment : BaseFragment<UserListViewModel, UserFragmentUserBinding>(
    R.layout.user_fragment_user,
    UserFragmentUserBinding::bind
) {

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultIdItemDiffCallback<UserItem>(),
            UserItem.delegate(viewModel::navigateFeed),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvContent.itemAnimator = null
            rvContent.adapter = adapter
            rvContent.addItemDecoration(DefaultItemDecoration())
            srlRefresh.setOnRefreshListener {
                viewModel.updateUserList()
            }
        }
    }

    override fun observeViewModel() {
        super.observeViewModel()

        subscribe(viewModel.userListFlow) {
            adapter.setItems(it)
        }

        subscribe(viewModel.navigateFeed) {
            navigator.navigateTo(UserListFragmentDirections.actionUserListToFeed(it))
        }

        subscribe(viewModel.isLoading) {
            binding.srlRefresh.isRefreshing = it
        }
    }
}
