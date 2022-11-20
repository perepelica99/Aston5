package com.example.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity() : AppCompatActivity(), Navigator {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, ContactsFragment())
            .commit()
    }

    override fun showContactFragment(contact: contacts_info
    ) {
        Log.e("TAg", "ACTION")
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, ContactsFragment.newInstance(contact = contact))
            .commit()
    }

    override fun showContactDetailsFragment(contact: contacts_info
    ) {
        Log.e("TAg", "ACTION1")
        supportFragmentManager
            .popBackStack("STACK", FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
            .addToBackStack("ContactDetails")
            .replace(R.id.fragmentContainer, DetailsFragment.newInstance(contact = contact))
            .commit()
    }

    override fun onBackPressed() {

        val lastFragments: FragmentManager = supportFragmentManager

        if (lastFragments.backStackEntryCount == 1) {
            lastFragments.popBackStack()
        } else {
            finish()
        }
    }

}
