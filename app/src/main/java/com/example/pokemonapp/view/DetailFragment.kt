package com.example.pokemonapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentDetailBinding
import com.example.pokemonapp.model.PokemonModel
import com.example.pokemonapp.util.downloadFromUrl
import com.example.pokemonapp.util.placeHolderProgressBar

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    lateinit var selectedPokemonItem: PokemonModel
    private val navigationArgs : DetailFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false)
        selectedPokemonItem = navigationArgs.pokemonItem

        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = selectedPokemonItem.name

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokemonDetailDescription.text = selectedPokemonItem.description
        context?.let {
            binding.pokemonDetailImage.downloadFromUrl(selectedPokemonItem.imageUrl, placeHolderProgressBar(it))
        }
    }
}