package com.example.pokedex.data

import com.example.pokedex.data.local.PokemonDatabase
import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.util.toDomainModel
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetail
import dagger.hilt.android.scopes.ActivityScoped
import java.util.*
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(
    private val api: PokeApi,
    private val pokemonDatabase: PokemonDatabase
): PokemonRepository {

    override suspend fun getPokemonList(page: Int): List<Pokemon> {
        val networkResult = api.getPokemonList(page, page * PAGE_SIZE)
        val pokedexEntries = networkResult.results.mapIndexed { _, entry ->
            entry.toDomainModel()
        }
        return pokedexEntries
    }

    override suspend fun getPokemonInfo(pokemonName: String): PokemonDetail {
        val pokemonDetail = api.getPokemonInfo(pokemonName)
        return pokemonDetail.toDomainModel()
    }

    companion object {
        const val PAGE_SIZE = 20
    }

}