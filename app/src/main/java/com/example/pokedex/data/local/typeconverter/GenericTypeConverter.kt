package com.example.pokedex.data.local.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

@ProvidedTypeConverter
abstract class GenericTypeConverter <T> (
    @PublishedApi internal val _moshi: Moshi
){
    @TypeConverter
    inline fun <reified T> fromJsonToType(value: String): List<T>? {
        val listType = Types.newParameterizedType(List::class.java, T::class.java)
        val adapter: JsonAdapter<List<T>> = _moshi.adapter(listType)
        return adapter.fromJson(value)
    }
    @TypeConverter
    inline fun <reified T> toJsonFromType(type: List<T>): String {
        val listType = Types.newParameterizedType(List::class.java, T::class.java)
        val adapter: JsonAdapter<List<T>> = _moshi.adapter(listType)
        return adapter.toJson(type)
    }

}