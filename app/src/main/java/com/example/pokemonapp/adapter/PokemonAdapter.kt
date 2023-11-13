package com.example.pokemonapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.PokemonModel
import com.example.pokemonapp.view.PokemonsFragmentDirections

class PokemonAdapter(val pokemonList: ArrayList<PokemonModel>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    class PokemonViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return  PokemonViewHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return  pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.binding.name.text = pokemonList[position].name
        holder.binding.description.text = pokemonList[position].description

        holder.itemView.setOnClickListener{
            val action = PokemonsFragmentDirections.actionPokemonsFragmentToDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun updateCountryList(newCountryList: List<PokemonModel>){
        pokemonList.clear()
        pokemonList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}