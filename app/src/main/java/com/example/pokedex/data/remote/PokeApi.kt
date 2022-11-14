package com.example.pokedex.data.remote

import com.example.pokedex.data.remote.data.PokemonApiResponse
import com.example.pokedex.data.remote.data.PokemonDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonApiResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokemonDetail

    companion object{
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}