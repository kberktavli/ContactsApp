package com.berktavli.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.databinding.FragmentPersonDetailBinding
import com.berktavli.contactsapp.ui.viewmodel.PersonDetailViewModel
import com.berktavli.contactsapp.ui.viewmodel.PersonRegistrationViewModel


class PersonDetailFragment : Fragment() {

    private lateinit var binding : FragmentPersonDetailBinding
    private lateinit var viewModel : PersonDetailViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_detail,container,false)

        binding.personDetailFragment = this
        binding.personDetailToolbarHead = "Person Detail"

        val bundle: PersonDetailFragmentArgs by navArgs()
        val receivePerson = bundle.person
        binding.personsObject = receivePerson

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonDetailViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun updatePerson(person_id : Int,person_name : String, person_phone : String ){
        viewModel.update(person_id,person_name,person_phone)
    }


}