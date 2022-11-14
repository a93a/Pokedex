package com.example.pokedex.data.util

import com.example.pokedex.data.local.data.Pokemon
import com.example.pokedex.data.local.data.PokemonDetail
import java.util.*

fun com.example.pokedex.data.remote.data.Pokemon.toDatabaseModel() = Pokemon(
    name = name.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.ROOT)
        else
            it.toString()
    },
    url = getImageUrl(),
    index = getIndex()
)

//fun com.example.pokedex.data.remote.data.PokemonDetail.toDatabaseModel() = PokemonDetail(

//)