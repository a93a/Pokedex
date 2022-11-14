package com.example.pokedex.domain.usecase

import com.example.pokedex.di.IoDispatcher
import com.example.pokedex.domain.repository.PokemonRepository
import com.example.pokedex.domain.UseCase
import com.example.pokedex.model.PokemonDetail
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
    private val remoteRepository: PokemonRepository
): UseCase<String, PokemonDetail>(coroutineDispatcher) {

    override suspend fun execute(parameters: String): PokemonDetail {
        return remoteRepository.getPokemonInfo(parameters)
    }

}