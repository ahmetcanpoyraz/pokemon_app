package com.example.pokemonapp.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.model.PokemonModel
import com.example.pokemonapp.service.PokemonAPIService
import kotlinx.coroutines.*


class PokemonsViewModel : ViewModel() {

    private val pokemonApiService = PokemonAPIService()
    val pokemons = MutableLiveData<List<PokemonModel>>()
    val pokemonError = MutableLiveData<Boolean>()
    val pokemonLoading = MutableLiveData<Boolean>()
    private var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler{coroutineContext, throwable -> println(throwable.message)  }

    fun refreshData(){
       getDataFromAPI()
    }

    private fun getDataFromAPI(){
        pokemonLoading.value = true

        job = CoroutineScope(Dispatchers.IO).launch {
            val response = pokemonApiService.getData()

            withContext(Dispatchers.Main + exceptionHandler){
                if(response.isSuccessful){
                    response.body()?.let {
                        pokemons.value = it
                        pokemonError.value = false
                        pokemonLoading.value = false
                    }
                }else{
                    pokemonError.value = true
                    pokemonLoading.value = false
                }
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }



}