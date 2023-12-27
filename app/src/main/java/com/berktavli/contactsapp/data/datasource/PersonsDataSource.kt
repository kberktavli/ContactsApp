package com.berktavli.contactsapp.data.datasource

import android.util.Log
import com.berktavli.contactsapp.data.entity.Persons
import com.berktavli.contactsapp.room.PersonsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonsDataSource(var personsDao: PersonsDao) {

    suspend fun personsLoad(): List<Persons> =
        withContext(Dispatchers.IO) {
            return@withContext personsDao.loadPerson()
        }
    suspend fun search(searchWord: String): List<Persons> =
        withContext(Dispatchers.IO) {

            return@withContext personsDao.search(searchWord)
        }
    suspend fun save(person_name: String, person_phone: String) {
        val newPerson = Persons(0, person_name, person_phone)
        personsDao.save(newPerson)
    }
    suspend fun update(person_id: Int, person_name: String, person_phone: String) {
        val updatePerson = Persons(person_id, person_name, person_phone)
        personsDao.update(updatePerson)
    }
    suspend fun delete(person_id: Int) {
        val deletePerson = Persons(person_id, "", "")
        personsDao.delete(deletePerson)
    }


}