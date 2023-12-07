package com.berktavli.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.databinding.FragmentPersonRegistrationBinding

class PersonRegistrationFragment : Fragment() {
    private lateinit var binding : FragmentPersonRegistrationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonRegistrationBinding.inflate(inflater, container, false)

        binding.toolbarPersonRegistration.title = "Sign Up"

        binding.buttonSave.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_phone = binding.editTextPersonPhone.text.toString()

            savePerson(person_name,person_phone)
        }

        return binding.root
    }

    fun savePerson(person_name : String, person_phone : String ){
        Log.e("Person","Tuşa basıldı")
        Log.e("Person","$person_name-$person_phone")
    }

}