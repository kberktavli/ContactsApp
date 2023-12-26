package com.berktavli.contactsapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.switch(it : View, id : Int){
    findNavController(it).navigate(id)
}

fun Navigation.switch(it : View, id : NavDirections){
    findNavController(it).navigate(id)
}