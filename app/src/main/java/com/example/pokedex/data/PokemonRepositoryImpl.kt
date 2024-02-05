package com.example.pokedex.data

import com.example.local.PokemonDatabase
import com.example.remote.remote.PokeApi
import com.example.pokedex.domain.mapper.asDomain
import com.example.pokedex.domain.mapper.asLocal
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetail
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(
    private val api: com.example.remote.remote.PokeApi,
    private val pokemonDatabase: com.example.local.PokemonDatabase
): PokemonRepository {

    override suspend fun getPokemonList(page: Int): List<Pokemon> {

        var databaseResult = pokemonDatabase.pokemonDao().getPokemonList(page * PAGE_SIZE).map { it.asDomain() }

        if (databaseResult.isEmpty()) {
            val networkResult = api.getPokemonList(page, page * PAGE_SIZE).results.map { it.asLocal() }
            pokemonDatabase.pokemonDao().insertPokemonList(networkResult)
            databaseResult = pokemonDatabase.pokemonDao().getPokemonList(page * PAGE_SIZE).map { it.asDomain() }
        }

        return databaseResult
    }

    override suspend fun getPokemonInfo(pokemonName: String): PokemonDetail {

        var databaseResult = pokemonDatabase.pokemonDetailDao().getPokemonInfo(pokemonName)

        if(databaseResult == null){

            val networkResult = api.getPokemonInfo(pokemonName).asLocal()
            pokemonDatabase.pokemonDetailDao().insertPokemonInfo(networkResult)
            databaseResult = pokemonDatabase.pokemonDetailDao().getPokemonInfo(pokemonName)
        }
        return databaseResult!!.asDomain() //temp
    }


    companion object {
        const val PAGE_SIZE = 20
    }

}