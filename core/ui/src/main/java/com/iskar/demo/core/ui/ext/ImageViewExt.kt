package com.iskar.demo.core.ui.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

fun ImageView.loadAvatar(url: String?) {
    Glide.with(this)
        .load(url)
        .transform(CircleCrop())
        .into(this)
}

fun ImageView.loadImage(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}
