package com.iskar.demo.core.ui.ext

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

fun <T> Fragment.subscribe(flow: (Flow<T>)?, onNext: (t: T) -> Unit) {
    view?.launchInViewScope {
        flow?.collect {
            if (it != null) {
                onNext(it)
            }
        }
    }
}

fun <T> Fragment.subscribe(liveData: (LiveData<T>)?, onNext: (t: T) -> Unit) {
    liveData?.observe(viewLifecycleOwner) {
        if (it != null) {
            onNext(it)
        }
    }
}

fun View.launchInViewScope(block: suspend CoroutineScope.() -> Unit): Job? =
    findViewTreeLifecycleOwner()?.lifecycleScope?.launchWhenCreated(block)
