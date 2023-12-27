package com.berktavli.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.berktavli.contactsapp.data.entity.Persons

@Dao
interface PersonsDao {
    /*
        @Query("SELECT * FROM persons")
        suspend fun loadPerson() : List<Persons>

        ( Data Access Object ) Veritabanı
    üzerindeki tablolarımızda
    yapacağımız işlemleri temsil eden
    sınıf.Örn: Silme,Ekleme vb.

     */

    @Query("SELECT * FROM persons")
    suspend fun loadPerson(): List<Persons>
    @Insert
    suspend fun save(person: Persons)
    @Update
    suspend fun update(person: Persons)
    @Delete
    suspend fun delete(person: Persons)
    @Query("SELECT * FROM persons WHERE person_name like '%' || :searchWord || '%'")
    suspend fun search(searchWord : String) : List<Persons>
}