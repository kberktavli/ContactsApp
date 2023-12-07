package com.berktavli.contactsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.data.entity.Persons
import com.berktavli.contactsapp.databinding.FragmentMainpageBinding


class MainpageFragment : Fragment() {
    private lateinit var binding : FragmentMainpageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainpageBinding.inflate(inflater,container,false)

        binding.buttonDetail.setOnClickListener {
            val person = Persons(1,"kadir","4444")
            val pass = MainpageFragmentDirections.personDetailAction(person)
            Navigation.findNavController(it).navigate(pass)
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.personRegistrationAction)
        }

        return binding.root
    }

}