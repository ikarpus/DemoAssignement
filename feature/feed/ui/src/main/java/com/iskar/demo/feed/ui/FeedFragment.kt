package com.iskar.demo.feed.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.iskar.demo.core.ui.base.BaseFragment
import com.iskar.demo.core.ui.ext.subscribe
import com.iskar.demo.core.ui.list.DefaultIdItemDiffCallback
import com.iskar.demo.feature.feed.ui.R
import com.iskar.demo.feature.feed.ui.databinding.FeedFragmentFeedBinding
import com.iskar.demo.feed.ui.list.FeedItemDecorator
import com.iskar.demo.feed.ui.list.models.FeedItem
import com.iskar.demo.feed.ui.list.models.HeaderItem
import com.iskar.demo.feed.ui.list.models.PostItem
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf

class FeedFragment : BaseFragment<FeedViewModel, FeedFragmentFeedBinding>(
    R.layout.feed_fragment_feed,
    FeedFragmentFeedBinding::bind
) {

    private val args: FeedFragmentArgs by navArgs()

    override fun getParameters(): ParametersDefinition = {
        parametersOf(args.params)
    }

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultIdItemDiffCallback<FeedItem>(),
            PostItem.delegate(),
            HeaderItem.delegate(),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            rvContent.itemAnimator = null
            rvContent.adapter = adapter
            rvContent.addItemDecoration(FeedItemDecorator())
            srlRefresh.setOnRefreshListener {
                viewModel.updateFeed()
            }
        }
    }

    override fun observeViewModel() {
        super.observeViewModel()

        subscribe(viewModel.feed) {
            adapter.setItems(it)
        }

        subscribe(viewModel.isLoading) {
            binding.srlRefresh.isRefreshing = it
        }
    }
}
