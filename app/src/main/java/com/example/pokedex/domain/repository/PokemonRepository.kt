package com.example.pokedex.domain.repository

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetail

interface PokemonRepository {

    suspend fun getPokemonList(page: Int): List<Pokemon>

    suspend fun getPokemonInfo(pokemonName: String): PokemonDetail

}