package com.iskar.demo.core.ui.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.iskar.demo.core.ui.ext.dp

class DefaultItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = 12.dp
        outRect.top = 8.dp
        outRect.right = 12.dp
        outRect.bottom = 8.dp
    }
}
