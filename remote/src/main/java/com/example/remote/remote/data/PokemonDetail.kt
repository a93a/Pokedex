package com.example.remote.remote.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetail(
    @field:Json(name = "base_experience") val base_experience: Int,
    @field:Json(name = "height") val height: Int,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "order") val order: Int,
    @field:Json(name = "sprites") val sprites: Sprites,
    @field:Json(name = "stats") val stats: List<Stat>,
    @field:Json(name = "types") val types: List<Type>,
    @field:Json(name = "weight") val weight: Int
){
    @JsonClass(generateAdapter = true)
    data class Sprites(
        @field:Json(name = "front_default") val frontDefault: String,
        @field:Json(name = "versions") val versions: Versions
    )

    @JsonClass(generateAdapter = true)
    data class Versions(
        @field:Json(name = "generation-v") val generationV: GenerationV
    )

    @JsonClass(generateAdapter = true)
    data class GenerationV(
        @field:Json(name = "black-white") val blackWhite: BlackWhite
    )

    @JsonClass(generateAdapter = true)
    data class BlackWhite(
        @field:Json(name = "animated") val animated: Animated
    )

    @JsonClass(generateAdapter = true)
    data class Animated(
        @field:Json(name = "front_default") val frontDefault: String
    )

    @JsonClass(generateAdapter = true)
    data class Stat(
        @field:Json(name = "base_stat") val baseStat: Int,
        @field:Json(name = "effort") val effort: Int,
        @field:Json(name = "stat") val stat: StatX
    )

    @JsonClass(generateAdapter = true)
    data class StatX(
        @field:Json(name = "name") val name: String,
        @field:Json(name = "url") val url: String
    )

    @JsonClass(generateAdapter = true)
    data class Type(
        @field:Json(name = "slot") val slot: Int,
        @field:Json(name = "type") val type: TypeX
    )

    @JsonClass(generateAdapter = true)
    data class TypeX(
        @field:Json(name = "name") val name: String,
        @field:Json(name = "url") val url: String
    )

}
