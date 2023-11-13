package com.example.pokemonapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.model.PokemonModel

class PokemonsViewModel : ViewModel() {
    val pokemons = MutableLiveData<List<PokemonModel>>()
    val pokemonError = MutableLiveData<Boolean>()
    val pokemonLoading = MutableLiveData<Boolean>()

    fun refreshData(){
       val pokemon1 = PokemonModel(1,"123","asd","as")
        val pokemon2 = PokemonModel(1,"123","asd","as")
        val pokemon3 = PokemonModel(1,"123","asd","as")

        val pokemonList = arrayListOf<PokemonModel>(pokemon1,pokemon2,pokemon3)
        pokemons.value = pokemonList
        pokemonError.value = false
        pokemonLoading.value = false

    }




}