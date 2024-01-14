package com.example.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.local.data.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<Pokemon>)

    @Query("SELECT * FROM Pokemon WHERE page = :page_")
    suspend fun getPokemonList(page_: Int): List<Pokemon>

    @Query("SELECT * FROM Pokemon WHERE page <= :page_")
    suspend fun getAllPokemonList(page_: Int): List<Pokemon>

    @Query("SELECT COUNT(*) FROM Pokemon")
    suspend fun getCount(): Int
}