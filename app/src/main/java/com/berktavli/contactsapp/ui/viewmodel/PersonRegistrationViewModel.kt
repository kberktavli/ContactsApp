package com.berktavli.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.berktavli.contactsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PersonRegistrationViewModel @Inject constructor(var prepo : PersonsRepository) : ViewModel() {
    fun save(person_name: String,person_phone: String){
        CoroutineScope(Dispatchers.Main).launch{
            prepo.save(person_name,person_phone)
        }
    }

}