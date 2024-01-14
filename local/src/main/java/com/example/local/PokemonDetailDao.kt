package com.example.local

import androidx.room.*
import com.example.local.data.PokemonDetail

@Dao
interface PokemonDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonInfo(pokemonInfo: PokemonDetail)

    @Query("SELECT * FROM PokemonDetail WHERE name = :name_")
    suspend fun getPokemonInfo(name_: String): PokemonDetail?
}