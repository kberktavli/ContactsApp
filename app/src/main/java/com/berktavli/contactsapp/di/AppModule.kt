package com.berktavli.contactsapp.di

import com.berktavli.contactsapp.data.datasource.PersonsDataSource
import com.berktavli.contactsapp.data.repo.PersonsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesPersonsDataSource() : PersonsDataSource{
        return PersonsDataSource()
    }

    @Provides
    @Singleton
    fun providesPersonsRepository(pds : PersonsDataSource) : PersonsRepository{
        return PersonsRepository(pds)
    }
}