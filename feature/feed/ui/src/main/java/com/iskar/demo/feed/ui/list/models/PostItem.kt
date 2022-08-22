package com.iskar.demo.feed.ui.list.models

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.iskar.demo.feature.feed.ui.databinding.FeedItemPostBinding

data class PostItem(
    override val id: Long,
    val body: String,
    val title: String,
) : FeedItem {

    companion object {

        fun delegate(): AdapterDelegate<List<FeedItem>> =
            adapterDelegateViewBinding<PostItem, FeedItem, FeedItemPostBinding>(
                { layoutInflater, root ->
                    FeedItemPostBinding.inflate(layoutInflater, root, false)
                }
            ) {
                bind {
                    with(binding) {
                        tvTitle.text = item.title
                        tvBody.text = item.body
                    }
                }
            }
    }
}
