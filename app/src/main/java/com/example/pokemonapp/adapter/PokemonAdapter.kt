package com.example.pokemonapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.PokemonModel
import com.example.pokemonapp.util.downloadFromUrl
import com.example.pokemonapp.util.placeHolderProgressBar
import com.example.pokemonapp.view.PokemonsFragmentDirections

class PokemonAdapter(private val pokemonList: ArrayList<PokemonModel>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


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
            val action = PokemonsFragmentDirections.actionPokemonsFragmentToDetailFragment(pokemonList[position])
            Navigation.findNavController(it).navigate(action)
        }

        holder.binding.imageView.downloadFromUrl(pokemonList[position].imageUrl, placeHolderProgressBar(holder.itemView.context))

    }

    fun updateCountryList(newCountryList: List<PokemonModel>){
        pokemonList.clear()
        pokemonList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}