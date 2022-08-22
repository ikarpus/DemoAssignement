package com.iskar.demo.feed.ui.list.models

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.iskar.demo.core.ui.ext.loadImage
import com.iskar.demo.feature.feed.ui.databinding.FeedItemHeaderBinding

data class HeaderItem(
    override val id: Long,
    val imageUrl: String?
) : FeedItem {

    companion object {

        fun delegate(): AdapterDelegate<List<FeedItem>> =
            adapterDelegateViewBinding<HeaderItem, FeedItem, FeedItemHeaderBinding>(
                { layoutInflater, root ->
                    FeedItemHeaderBinding.inflate(layoutInflater, root, false)
                }
            ) {
                bind {
                    with(binding) {
                        ivHeader.loadImage(item.imageUrl)
                    }
                }
            }
    }
}
