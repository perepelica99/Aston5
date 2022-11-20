package com.example.contacts

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.contacts.databinding.FragmentContactsBinding
import com.example.contacts.databinding.FragmentDetailsBinding

private const val KEY_CONTACT = "CONTACT"


class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)



        arguments?.let {
            let {
                when (requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Id) {
                    1 -> {
                        binding.tvName1.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Name
                        binding.tvSurname1.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Surname
                        binding.tvPhoneNumber1.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Phone
                    }
                    2 -> {
                        binding.tvName2.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Name
                        binding.tvSurname2.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Surname
                        binding.tvPhoneNumber2.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Phone
                    }
                    3 -> {
                        binding.tvName3.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Name
                        binding.tvSurname3.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Surname
                        binding.tvPhoneNumber3.text = requireArguments().getParcelable<contacts_info>(KEY_CONTACT)?.Phone
                    }
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstContact.setOnClickListener {
            navigator().showContactDetailsFragment(
                contacts_info(
                    Name = binding.tvName1.text.toString(),
                    Surname = binding.tvSurname1.text.toString(),
                    Phone = binding.tvPhoneNumber1.text.toString(),
                    Id = 1
                )
            )
        }

        binding.secondContact.setOnClickListener {
            navigator().showContactDetailsFragment(

                contacts_info(
                    Name = binding.tvName2.text.toString(),
                    Surname = binding.tvSurname2.text.toString(),
                    Phone = binding.tvPhoneNumber2.text.toString(),
                    Id = 2
                )
            )
        }

        binding.thirdContact.setOnClickListener {
            navigator().showContactDetailsFragment(
                contacts_info(
                    Name = binding.tvName3.text.toString(),
                    Surname = binding.tvSurname3.text.toString(),
                    Phone = binding.tvPhoneNumber3.text.toString(),
                    Id = 3
                )
            )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(contact: contacts_info) =
            ContactsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_CONTACT, contact)
                }
            }
    }
}