package com.example.pokedex.ui.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokedex.domain.usecase.GetPokemonInfoUseCase
import com.example.pokedex.model.PokemonDetail
import com.example.pokedex.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDetail> {
        return getPokemonInfoUseCase.invoke(pokemonName)
    }

}