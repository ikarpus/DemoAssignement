package com.iskar.demo.navigation.args

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedFragmentParams(
    val userId: Long,
    val imageUrl: String?
) : Parcelable
