package com.example.contacts

import androidx.annotation.StringRes

interface HasCustomTitle {

    @StringRes
    fun getTitleRes(): Int
}