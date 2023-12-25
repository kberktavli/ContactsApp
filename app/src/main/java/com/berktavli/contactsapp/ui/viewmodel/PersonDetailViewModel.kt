package com.berktavli.contactsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.berktavli.contactsapp.data.repo.PersonsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonDetailViewModel : ViewModel() {
    var prepo = PersonsRepository()
    fun update(person_id : Int,person_name : String, person_phone : String ){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.update(person_id,person_name,person_phone)
        }
    }
}