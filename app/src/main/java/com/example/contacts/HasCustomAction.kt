package com.example.contacts

import android.media.session.PlaybackState
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.util.concurrent.RunnableScheduledFuture

interface HasCustomAction {
    fun getCustomAction(): PlaybackState.CustomAction
}

class CustomAction(
    @DrawableRes val iconRes: Int,
    @StringRes val textRes: Int,
    val onCustomAction: Runnable
)