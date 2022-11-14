package com.example.pokedex.data.util

import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonDetail
import java.util.*

fun com.example.pokedex.data.remote.data.PokemonDetail.toDomainModel() = PokemonDetail(
    name = name,
    height = height,
    weight = weight,
    id = id,
    url = sprites.versions.generationV.blackWhite.animated.frontDefault,
    types = types.map {
        it.type.name
    },
    stats = stats.map {
        PokemonDetail.Stat(
            baseStat = it.baseStat,
            stat = it.stat.name
        )
    }
)

fun com.example.pokedex.data.remote.data.Pokemon.toDomainModel() = Pokemon(
    name = name.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.ROOT)
        else
            it.toString()
    },
    url = getImageUrl(),
    index = getIndex()
)
