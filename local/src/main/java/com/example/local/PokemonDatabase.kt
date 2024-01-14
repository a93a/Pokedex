package com.example.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.local.data.Pokemon
import com.example.local.data.PokemonDetail
import com.example.local.typeconverter.TypeConverter

@Database(entities = [Pokemon::class, PokemonDetail::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonDetailDao(): PokemonDetailDao

    companion object{
        const val POKEMON_DATABASE = "pokemondatabase"
    }

}