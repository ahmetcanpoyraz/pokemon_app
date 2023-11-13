package com.example.pokemonapp.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?
)