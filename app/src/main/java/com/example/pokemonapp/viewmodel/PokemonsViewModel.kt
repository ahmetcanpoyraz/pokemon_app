package com.example.pokemonapp.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.model.PokemonModel
import com.example.pokemonapp.service.PokemonAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers



class PokemonsViewModel : ViewModel() {

    private val pokemonApiService = PokemonAPIService()
    private val disposable = CompositeDisposable()

    val pokemons = MutableLiveData<List<PokemonModel>>()
    val pokemonError = MutableLiveData<Boolean>()
    val pokemonLoading = MutableLiveData<Boolean>()

    fun refreshData(){
       getDataFromAPI()
    }

    private fun getDataFromAPI(){
        pokemonLoading.value = true
        disposable.add(
            pokemonApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<PokemonModel>>(){
                    override fun onSuccess(value: List<PokemonModel>) {
                        pokemons.value = value
                        pokemonError.value = false
                        pokemonLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        pokemonError.value = true
                        pokemonLoading.value = false
                        e.printStackTrace()
                    }

                })

        )
    }



}