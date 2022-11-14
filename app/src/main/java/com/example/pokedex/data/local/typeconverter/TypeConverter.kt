package com.example.pokedex.data.local.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.pokedex.data.remote.data.PokemonDetail
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class TypeConverter @Inject constructor(
    private val moshi: Moshi
){
    @TypeConverter
    fun fromJsonToStat(value: String): List<PokemonDetail.Stat>? {
        val listType = Types.newParameterizedType(List::class.java, PokemonDetail.Stat::class.java)
        val adapter: JsonAdapter<List<PokemonDetail.Stat>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }
    @TypeConverter
    fun toJsonFromStat(value: List<PokemonDetail.Stat>): String {
        val listType = Types.newParameterizedType(List::class.java, PokemonDetail.Stat::class.java)
        val adapter: JsonAdapter<List<PokemonDetail.Stat>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun fromJsonToString(value: String): List<String>? {
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJsonFromString(value: List<String>): String {
        val listType = Types.newParameterizedType(List::class.java, String::class.java)
        val adapter: JsonAdapter<List<String>> = moshi.adapter(listType)
        return adapter.toJson(value)
    }

}
