package com.iskar.demo.feed.ui.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iskar.demo.core.ui.ext.dp

class FeedItemDecorator : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        with(outRect) {
            if (position == 0) {
                left = 0
                top = 0
                right = 0
            } else {
                left = 12.dp
                top = 8.dp
                right = 12.dp
            }
            bottom = 8.dp
        }
    }
}
