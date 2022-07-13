package com.example.pokedex.domain

import com.example.pokedex.data.remote.response.Pokemon
import com.example.pokedex.data.remote.response.PokemonList
import com.example.pokedex.model.Resource

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon>

}