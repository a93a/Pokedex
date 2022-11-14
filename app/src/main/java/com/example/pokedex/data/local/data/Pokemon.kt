package com.example.pokedex.data.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pokemon(
    @PrimaryKey val name: String,
    val url: String,
    var page: Int = 0,
    val index: Int
)