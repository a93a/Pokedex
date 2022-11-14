package com.example.pokedex.domain.usecase

import com.example.pokedex.di.IoDispatcher
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.domain.UseCase
import com.example.pokedex.model.Pokemon
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val remoteRepository: PokemonRepository
): UseCase<Int, List<Pokemon>>(coroutineDispatcher) {

    override suspend fun execute(parameters: Int): List<Pokemon> {
        return remoteRepository.getPokemonList(parameters)
    }

}

