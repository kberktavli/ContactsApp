package com.berktavli.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.databinding.FragmentPersonDetailBinding


class PersonDetailFragment : Fragment() {

    private lateinit var binding : FragmentPersonDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater,container,false)


        binding.toolbarPersonDetail.title = " Person Detail"

        val bundle: PersonDetailFragmentArgs by navArgs()
        val receivePerson = bundle.person

        binding.editTextPersonName.setText(receivePerson.person_name)
        binding.editTextPersonPhone.setText(receivePerson.person_phone)

        binding.buttonUpdate.setOnClickListener {
            val person_name = binding.editTextPersonName.text.toString()
            val person_phone = binding.editTextPersonPhone.text.toString()
            val person_id =
            updatePerson(receivePerson.person_id,person_name,person_phone)
        }

        return binding.root
    }

    fun updatePerson(person_id : Int,person_name : String, person_phone : String ){
        Log.e("Person","Güncellendi")
        Log.e("Person","$person_id-$person_name-$person_phone")
    }
}