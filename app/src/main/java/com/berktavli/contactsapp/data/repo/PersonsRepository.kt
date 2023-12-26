package com.berktavli.contactsapp.data.repo


import com.berktavli.contactsapp.data.datasource.PersonsDataSource
import com.berktavli.contactsapp.data.entity.Persons

class PersonsRepository (var pds : PersonsDataSource){

    suspend fun save(person_name : String, person_phone : String ) = pds.save(person_name,person_phone)
    suspend fun update(person_id : Int,person_name : String, person_phone : String ) = pds.update(person_id,person_name,person_phone)
    suspend fun delete(person_id : Int) = pds.delete(person_id)
    suspend fun personsLoad() : List<Persons> = pds.personsLoad()
    suspend fun search(searchWord : String) :List<Persons> = pds.search(searchWord)
}