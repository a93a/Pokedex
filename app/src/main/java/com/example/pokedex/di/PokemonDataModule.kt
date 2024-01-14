package com.example.pokedex.di

import android.app.Application
import androidx.room.Room
import com.example.local.PokemonDatabase
import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.PokemonRepositoryImpl
import com.example.local.typeconverter.TypeConverter
import com.example.pokedex.data.remote.PokeApi.Companion.BASE_URL
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
    fun providePokeApi(): PokeApi = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(PokeApi::class.java)


    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi,
        pokemonDatabase: PokemonDatabase
    ): PokemonRepository = PokemonRepositoryImpl(api,pokemonDatabase)

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

}

