package com.example.pokedex.model

import com.example.pokedex.data.remote.data.PokemonDetail
import com.squareup.moshi.Json

data class PokemonDetail(
    val height: Int,
    val id: Int,
    val name: String,
    val weight: Int,
    val url: String,
    val stats: List<Stat>,
    val types: List<String>

){
    companion object {
        const val maxAttribute = 300
    }

    data class Stat(
        val baseStat: Int,
        val stat: String
    )
}
