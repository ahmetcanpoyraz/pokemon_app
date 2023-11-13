package com.example.pokemonapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonsBinding


class PokemonsFragment : Fragment() {

    private lateinit var binding : FragmentPokemonsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemons,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     /*   binding.fragmentButton.setOnClickListener{
            val  action = PokemonsFragmentDirections.actionPokemonsFragmentToDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }*/
    }

}