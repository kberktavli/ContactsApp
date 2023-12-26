package com.berktavli.contactsapp.data.datasource

import android.util.Log
import com.berktavli.contactsapp.data.entity.Persons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonsDataSource {

    suspend fun personsLoad() : List<Persons> =
        withContext(Dispatchers.IO){

            val personList = ArrayList<Persons>()
            val k1 = Persons(1,"Ayse","4444")
            val k2 = Persons(2,"Kadir","5555")
            val k3 = Persons(3,"Efe","44455")
            val k4 = Persons(4,"Mert","5524")

            personList.add(k1)
            personList.add(k2)
            personList.add(k3)
            personList.add(k4)
            return@withContext personList
        }
    suspend fun search(searchWord : String) :List<Persons> =
        withContext(Dispatchers.IO){

        val personList = ArrayList<Persons>()
        val k1 = Persons(1,"Ayse","4444")
        personList.add(k1)
        return@withContext personList
    }
    suspend fun save(person_name : String, person_phone : String ){
        Log.e("Person","Tuşa basıldı")
        Log.e("Person","$person_name-$person_phone")
    }

    suspend fun update(person_id : Int,person_name : String, person_phone : String ){
        Log.e("Person","Güncellendi")
        Log.e("Person","$person_id-$person_name-$person_phone")
    }

    suspend fun delete(person_id : Int){
        Log.e("Kişi Sil", person_id.toString())
    }

}