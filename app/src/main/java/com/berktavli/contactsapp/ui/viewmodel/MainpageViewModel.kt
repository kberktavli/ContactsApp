package com.berktavli.contactsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berktavli.contactsapp.data.entity.Persons
import com.berktavli.contactsapp.data.repo.PersonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainpageViewModel @Inject constructor(var prepo : PersonsRepository) : ViewModel() {
    var personList = MutableLiveData<List<Persons>>()

    init {
        personsLoad()
    }
    


     fun delete(person_id : Int){
        CoroutineScope(Dispatchers.Main).launch {
            prepo.delete(person_id)
            personsLoad()
        }
    }
     fun personsLoad(){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = prepo.personsLoad()
        }
    }

    fun search(searchWord : String){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = prepo.search(searchWord)
        }
    }

}