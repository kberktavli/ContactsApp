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
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.data.entity.Persons
import com.berktavli.contactsapp.databinding.FragmentMainpageBinding
import com.berktavli.contactsapp.ui.adapter.PersonsAdapter
import com.berktavli.contactsapp.ui.viewmodel.MainpageViewModel
import com.berktavli.contactsapp.ui.viewmodel.PersonRegistrationViewModel
import com.berktavli.contactsapp.util.switch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainpageFragment : Fragment() {
    private lateinit var binding : FragmentMainpageBinding
    private lateinit var viewModel : MainpageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mainpage,container,false)
        binding.mainPageFragment = this
        binding.mainPageToolbarHead= "Contacts"

        viewModel.personList.observe(viewLifecycleOwner){
            val personsAdapter = PersonsAdapter(requireContext(),it,viewModel)
            binding.personsAdapter = personsAdapter
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainpageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun clickFab(it : View){
        Navigation.switch(it,R.id.personRegistrationAction)
    }

    override fun onResume() {
        super.onResume()
        viewModel.personsLoad()
    }


}
