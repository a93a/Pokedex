package com.example.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokedex.data.local.data.Pokemon
import com.example.pokedex.data.local.data.PokemonDetail
import com.example.pokedex.data.local.typeconverter.TypeConverter

@Database(entities = [Pokemon::class, PokemonDetail::class], version = 1, exportSchema = true)
@TypeConverters(TypeConverter::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonDetailDao(): PokemonDetailDao

    companion object{
        const val POKEMON_DATABASE = "pokemondatabase"
    }

}