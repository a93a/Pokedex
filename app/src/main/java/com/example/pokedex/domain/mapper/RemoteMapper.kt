package com.example.pokedex.domain.mapper

import com.example.local.data.Stat
import com.example.pokedex.model.PokemonDetail as PokemonDetailModel
import com.example.remote.remote.data.PokemonDetail as PokemonDetailRemote
import com.example.local.data.PokemonDetail as PokemonDetailLocal
import com.example.local.data.Pokemon as PokemonDatabase
import com.example.remote.remote.data.Pokemon as PokemonRemote


fun PokemonRemote.asLocal() = PokemonDatabase(
    name = name,
    url = getImageUrl(),
    index = getIndex()
)

fun PokemonDetailRemote.asDomain() = PokemonDetailModel(
    name = name,
    height = height,
    weight = weight,
    id = id,
    url = sprites.versions.generationV.blackWhite.animated.frontDefault,
    types = types.map {
        it.type.name
    },
    stats = stats.map {
        PokemonDetailModel.Stat(
            baseStat = it.baseStat,
            stat = it.stat.name
        )
    }
)

fun PokemonDetailRemote.asLocal() = PokemonDetailLocal(
    name = name,
    height = height,
    weight = weight,
    id = id,
    url = sprites.versions.generationV.blackWhite.animated.frontDefault,
    types = types.map {
                      it.type.name
    },
    stats = stats.map {
        com.example.local.data.Stat(
            baseStat = it.baseStat,
            stat = it.stat.name
        )
    }
)