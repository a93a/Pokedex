package com.example.pokedex.data.remote.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pokemon(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "url") val url: String
){
    fun getImageUrl(): String {
        val index = getIndex()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${index}.png"
    }

    fun getIndex(): Int {
        return url.split("/".toRegex()).dropLast(1).last().toInt()
    }
}