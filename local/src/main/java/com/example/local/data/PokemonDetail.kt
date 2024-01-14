package com.example.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class PokemonDetail(
    val height: Int,
    @PrimaryKey val id: Int,
    val name: String,
    val weight: Int,
    val url: String,
    val stats: List<Stat>,
    val types: List<String>

)

@JsonClass(generateAdapter = true)
data class Stat(
    val baseStat: Int,
    val stat: String
)