package com.example.pokemonapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.R
import com.example.pokemonapp.adapter.PokemonAdapter
import com.example.pokemonapp.databinding.FragmentPokemonsBinding
import com.example.pokemonapp.viewmodel.PokemonsViewModel


class PokemonsFragment : Fragment() {

    private lateinit var viewModel: PokemonsViewModel
    private val pokemonAdapter = PokemonAdapter(arrayListOf())
    private lateinit var binding : FragmentPokemonsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Pokemon"
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemons,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[PokemonsViewModel :: class.java]
        viewModel.refreshData()
        binding.pokemonList.layoutManager = LinearLayoutManager(context)
        binding.pokemonList.adapter = pokemonAdapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.pokemonList.visibility = View.GONE
            binding.pokemonsLoading.visibility = View.VISIBLE
            binding.pokemonError.visibility = View.GONE
            viewModel.refreshData()
            binding.swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()
    }


    private fun observeLiveData(){
        viewModel.pokemons.observe(viewLifecycleOwner, Observer { pokemons ->
            pokemons?.let {
                binding.pokemonList.visibility = View.VISIBLE
                pokemonAdapter.updateCountryList(pokemons)
            }
        })

        viewModel.pokemonError.observe(viewLifecycleOwner, Observer { error->
            error?.let {
                if(it){
                    binding.pokemonError.visibility = View.VISIBLE
                }else{
                    binding.pokemonError.visibility = View.GONE
                }
            }
        })

        viewModel.pokemonLoading.observe(viewLifecycleOwner, Observer { loading->
            loading?.let {
                if(it){
                    binding.pokemonsLoading.visibility = View.VISIBLE
                    binding.pokemonList.visibility = View.GONE
                    binding.pokemonError.visibility = View.GONE
                }else{
                    binding.pokemonsLoading.visibility = View.GONE
                }
            }

        })
    }

}