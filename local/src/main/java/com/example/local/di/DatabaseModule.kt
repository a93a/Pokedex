package com.example.local.di

import android.app.Application
import androidx.room.Room
import com.example.local.typeconverter.TypeConverter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideTypeConverter(moshi: Moshi): TypeConverter = TypeConverter(moshi)

    @Singleton
    @Provides
    fun provideAppDatabase(
        application: Application,
        typeConverter: TypeConverter
    ): com.example.local.PokemonDatabase = Room
        .databaseBuilder(application, com.example.local.PokemonDatabase::class.java,
            com.example.local.PokemonDatabase.POKEMON_DATABASE
        )
        .addTypeConverter(typeConverter)
        .fallbackToDestructiveMigration()
        .build()
}