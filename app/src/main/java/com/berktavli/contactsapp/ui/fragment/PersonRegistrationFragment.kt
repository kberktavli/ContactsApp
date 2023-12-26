package com.berktavli.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.databinding.FragmentPersonRegistrationBinding
import com.berktavli.contactsapp.ui.viewmodel.PersonRegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonRegistrationFragment: Fragment() {
    private lateinit var binding: FragmentPersonRegistrationBinding
    private lateinit var viewModel: PersonRegistrationViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_registration,container ,false)
        binding.personRegistrationFragment = this
        binding.personRegistrationToolbarHead = "Sign Up"



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonRegistrationViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun savePerson(person_name : String, person_phone : String ){
        viewModel.save(person_name,person_phone)
    }

}