package com.iskar.demo.core.ui.list

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DefaultIdItemDiffCallback<T : IdItemModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

}
