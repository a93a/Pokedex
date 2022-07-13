package com.example.pokedex.model

data class PokemonListRequest(
    private val limit: Int,
    private val offset: Int
)
