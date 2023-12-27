package com.berktavli.contactsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.berktavli.contactsapp.data.entity.Persons

@Database(entities = [Persons::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun loadPerson() : PersonsDao

    /*
    Veritabanımızı temsil eden
sınıftır.Bu sınıf sayesinde
veritabanı üzerinde işlem
yapabiliriz.

     */
}