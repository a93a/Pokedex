package com.example.pokedex.di

import android.app.Application
import androidx.room.Room
import com.example.local.PokemonDatabase
import com.example.remote.remote.PokeApi
import com.example.pokedex.data.PokemonRepositoryImpl
import com.example.local.typeconverter.TypeConverter
import com.example.remote.remote.PokeApi.Companion.BASE_URL
import com.example.pokedex.domain.repository.PokemonRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PokemonDataModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: com.example.remote.remote.PokeApi,
        pokemonDatabase: PokemonDatabase
    ): PokemonRepository = PokemonRepositoryImpl(api,pokemonDatabase)

}

