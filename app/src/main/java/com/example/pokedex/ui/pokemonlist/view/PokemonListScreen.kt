package com.example.pokedex.ui.pokemonlist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokedex.R
import com.example.pokedex.ui.pokemonlist.PokemonListViewModel

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        var hideKeyboard by remember {
            mutableStateOf(false)
        }//new
        Column(
            modifier = Modifier.clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                hideKeyboard = true
            }
        ) {//new
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            SearchBar(
                hint = "Search",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                hideKeyboard = hideKeyboard,
                onFocusClear = {
                    hideKeyboard = false
                               },
                onSearch = { search ->
                    viewModel.searchPokemonList(search)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            PokemonList(navController = navController)
        }
    }
}

