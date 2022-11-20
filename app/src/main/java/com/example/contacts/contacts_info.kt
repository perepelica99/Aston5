package com.example.contacts

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class contacts_info(
    val Name: String?,
    val Surname: String?,
    val Phone: String?,
    val Id: Int
) : Parcelable
