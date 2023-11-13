package com.example.pokemonapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentDetailBinding
import com.example.pokemonapp.databinding.FragmentPokemonsBinding
import com.example.pokemonapp.viewmodel.DetailViewModel
import com.example.pokemonapp.viewmodel.PokemonsViewModel

class DetailFragment : Fragment() {

    private  lateinit var viewModel : DetailViewModel
    private  var pokemonUuid = 0
    private lateinit var binding : FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DetailViewModel :: class.java]

   /*     arguments?.let {
            pokemonUuid = DetailFragmentArgs.fromBundle(it).pokemonUuid
        }*/
    }

    private fun observeLiveData(){
        viewModel.detailLiveData.observe(viewLifecycleOwner, Observer { pokemon->
            pokemon?.let {
                binding.pokemonDetailDescription.text = pokemon.description
            }
        })
    }

}