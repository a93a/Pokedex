package com.example.pokedex.domain.mapper

import com.example.pokedex.data.local.data.Pokemon as PokemonDatabase
import com.example.pokedex.model.Pokemon as PokemonModel
import com.example.pokedex.model.PokemonDetail as PokemonDetailModel
import com.example.pokedex.data.local.data.PokemonDetail as PokemonDetailDatabase

fun PokemonDatabase.asDomain() = PokemonModel(
    name = name,
    url = url,
    index = index
)

fun PokemonDetailDatabase.asDomain() = PokemonDetailModel(
    height = height,
    name = name,
    url = url,
    id = id,
    weight = weight,
    types = types,
    stats = stats.map{
        PokemonDetailModel.Stat(
            baseStat = it.baseStat,
            stat = it.stat
        )
    }
)