package com.example.pokedex.ui.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.remote.response.Pokemon
import com.example.pokedex.domain.PokemonRepository
import com.example.pokedex.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }

}