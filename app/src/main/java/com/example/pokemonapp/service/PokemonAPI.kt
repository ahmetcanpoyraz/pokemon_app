package com.example.pokemonapp.service

import com.example.pokemonapp.model.PokemonModel
import retrofit2.Response
import retrofit2.http.GET

interface PokemonAPI {

    @GET("DavidCorrado/8912aa29d7c4a5fbf03993b32916d601/raw/681ef0b793ab444f2d81f04f605037fb44814125/pokemon.json")
    suspend fun getPokemons(): Response<List<PokemonModel>>
}