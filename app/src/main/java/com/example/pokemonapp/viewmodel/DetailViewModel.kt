package com.example.pokemonapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.model.PokemonModel

class DetailViewModel : ViewModel() {

    val detailLiveData = MutableLiveData<PokemonModel>()


}