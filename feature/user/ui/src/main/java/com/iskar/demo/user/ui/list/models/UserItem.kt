package com.iskar.demo.user.ui.list.models

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.iskar.demo.core.ui.ext.loadAvatar
import com.iskar.demo.core.ui.list.IdItemModel
import com.iskar.demo.feature.user.ui.databinding.UserItemUserBinding

data class UserItem(
    override val id: Long,
    val name: String,
    val thumbnailUrl: String?,
    val postCount: Int,
) : IdItemModel {

    companion object {

        fun delegate(
            onItemClickListener: (Long) -> Unit
        ): AdapterDelegate<List<UserItem>> =
            adapterDelegateViewBinding(
                { layoutInflater, root ->
                    UserItemUserBinding.inflate(layoutInflater, root, false)
                }
            ) {
                bind {
                    with(binding) {
                        root.setOnClickListener {
                            onItemClickListener.invoke(item.id)
                        }
                        tvName.text = item.name
                        tvCount.text = item.postCount.toString()
                        ivThumbnail.loadAvatar(item.thumbnailUrl)
                    }
                }
            }
    }
}
