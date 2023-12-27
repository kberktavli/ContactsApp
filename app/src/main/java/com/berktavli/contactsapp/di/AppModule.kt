package com.berktavli.contactsapp.di

import android.content.Context
import androidx.room.Room
import com.berktavli.contactsapp.data.datasource.PersonsDataSource
import com.berktavli.contactsapp.data.repo.PersonsRepository
import com.berktavli.contactsapp.room.Database
import com.berktavli.contactsapp.room.PersonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesPersonsDataSource(personsDao: PersonsDao): PersonsDataSource {
        return PersonsDataSource(personsDao)
    }

    @Provides
    @Singleton
    fun providesPersonsRepository(pds: PersonsDataSource): PersonsRepository {
        return PersonsRepository(pds)
    }

    @Provides
    @Singleton
    fun providesPersonsDao(@ApplicationContext context: Context): PersonsDao {
        val db = Room.databaseBuilder(context, Database::class.java, "directory.sqlite")
            .createFromAsset("directory.sqlite").build()
        return db.loadPerson()
    }

}