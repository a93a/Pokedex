package com.example.pokedex.ui.pokemondetail.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.model.PokemonDetail
import com.example.pokedex.model.Resource
import com.example.pokedex.ui.theme.lightGrey

@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo: Resource<PokemonDetail>,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier
) {
    when(pokemonInfo) {
        is Resource.Success -> {
            PokemonDetailSection(
                info = pokemonInfo.data!!,
                modifier = modifier
                    //.offset(y = (-20).dp)
                    .padding(16.dp)
            )
        }
        is Resource.Error -> {
            Text(
                text = pokemonInfo.message!!,
                color = Color.Red,
                modifier = modifier
            )
        }
        is Resource.Loading -> {
            CircularProgressIndicator(
                color = lightGrey,
                modifier = loadingModifier
            )
        }
    }
}