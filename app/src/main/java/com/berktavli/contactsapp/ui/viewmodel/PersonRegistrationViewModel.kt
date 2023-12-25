package com.berktavli.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.berktavli.contactsapp.data.repo.PersonsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonRegistrationViewModel : ViewModel() {
    var prepo = PersonsRepository()
    fun save(person_name: String,person_phone: String){
        CoroutineScope(Dispatchers.Main).launch{
            prepo.save(person_name,person_phone)
        }
    }

}