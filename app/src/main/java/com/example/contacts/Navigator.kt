package com.example.contacts

import androidx.fragment.app.Fragment

fun Fragment.navigator() : Navigator{
    return requireActivity() as Navigator
}

interface Navigator {

    fun showContactFragment(contact: contacts_info)

    fun showContactDetailsFragment(contact: contacts_info)


}

