package com.example.pokemonapp.service

import com.example.pokemonapp.model.PokemonModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonAPIService {
    private val BASE_URL = "https://gist.githubusercontent.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokemonAPI::class.java)


    suspend fun getData() : Response<List<PokemonModel>> {
        return api.getPokemons()
    }
}