package com.berktavli.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.data.entity.Persons
import com.berktavli.contactsapp.databinding.FragmentMainpageBinding
import com.berktavli.contactsapp.ui.adapter.PersonsAdapter


class MainpageFragment : Fragment() {
    private lateinit var binding : FragmentMainpageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage,container,false)
        binding.mainPageFragment = this
        binding.mainPageToolbarHead= "Contacts"


        val personList = ArrayList<Persons>()

        val k1 = Persons(1,"Ayse","4444")
        val k2 = Persons(2,"Kadir","5555")
        val k3 = Persons(3,"Efe","44455")
        val k4 = Persons(4,"Mert","5524")

        personList.add(k1)
        personList.add(k2)
        personList.add(k3)
        personList.add(k4)

        val personsAdapter = PersonsAdapter(requireContext(),personList)
        binding.personsAdapter = personsAdapter




        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.personRegistrationAction)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })



        return binding.root
    }

    fun search(searchWord : String){
        Log.e("Search Word",searchWord)

    }

    fun clickFab(it : View){
        Navigation.findNavController(it).navigate(R.id.personRegistrationAction)
    }


}


/*
       binding.buttonDetail.setOnClickListener {
           val person = Persons(1,"kadir","4444")
           val pass = MainpageFragmentDirections.personDetailAction(person)
           Navigation.findNavController(it).navigate(pass)
       }
        */