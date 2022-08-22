package com.iskar.demo.navigation

import androidx.navigation.NavDirections

interface Navigator {
    fun navigateTo(direction: NavDirections)
}
