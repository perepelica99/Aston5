package com.example.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.contacts.databinding.FragmentContactsBinding
import com.example.contacts.databinding.FragmentDetailsBinding

private const val KEY_CONTACT = "CONTACT"

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var contact: contacts_info

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        arguments?.let {
            contact = it.getParcelable(KEY_CONTACT)!!
        }

        binding.contactName.text = contact.Name
        binding.contactSurname.text = contact.Surname
        binding.contactPhone.text = contact.Phone

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            navigator().showContactFragment(
                contacts_info(
                    Name = binding.etFirstNameContact.text.toString(),
                    Surname = binding.etLastNameContact.text.toString(),
                    Phone = binding.etPhoneNumberContact.text.toString(),
                    Id = contact.Id
                )
            )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(contact: contacts_info) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_CONTACT, contact)
                }
            }
    }
}