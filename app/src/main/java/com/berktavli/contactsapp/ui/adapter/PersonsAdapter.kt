package com.berktavli.contactsapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.berktavli.contactsapp.R
import com.berktavli.contactsapp.data.entity.Persons
import com.berktavli.contactsapp.databinding.CardViewBinding
import com.berktavli.contactsapp.databinding.FragmentMainpageBinding
import com.berktavli.contactsapp.ui.fragment.MainpageFragmentDirections
import com.berktavli.contactsapp.ui.viewmodel.MainpageViewModel
import com.berktavli.contactsapp.util.switch
import com.google.android.material.snackbar.Snackbar

class PersonsAdapter(var mContext : Context, var personsList:List<Persons>, var viewModel : MainpageViewModel) : RecyclerView.Adapter<PersonsAdapter.CardViewHolder>(){
    inner class CardViewHolder( val design : CardViewBinding) : RecyclerView.ViewHolder(design.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding : CardViewBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.card_view,parent,false)
        return CardViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val person = personsList.get(position)
        val d = holder.design

        d.personObject = person
        d.cardViewRow.setOnClickListener {
            val pass = MainpageFragmentDirections.personDetailAction(person = person)
            //Navigation.findNavController(it).navigate(pass)
            Navigation.switch(it,pass)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Silinsin mi ? ${person.person_id}",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    viewModel.delete(person.person_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return personsList.size
    }
}