package com.example.pokedex.ui.pokemonlist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.pokedex.data.PokemonRepositoryImpl.Companion.PAGE_SIZE
import com.example.pokedex.di.DefaultDispatcher
import com.example.pokedex.domain.usecase.GetPokemonListUseCase
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase,
    @DefaultDispatcher private val coroutineDispatcher: CoroutineDispatcher
): ViewModel() {

    private var currentPage = 0

    var pokemonList = mutableStateOf<List<Pokemon>>(listOf())
        private set
    var loadError = mutableStateOf("")
        private set
    var isLoading = mutableStateOf(false)
        private set
    var endReached = mutableStateOf(false)
        private set

    private var cachedPokemonList = listOf<Pokemon>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)
        private set

    init {
        loadPokemonPaginated()
    }

    fun searchPokemonList(query: String) {
        val listToSearch = if(isSearchStarting) {
            pokemonList.value
        } else {
            cachedPokemonList
        }
        viewModelScope.launch(coroutineDispatcher) {
            if(query.isEmpty()) {
                pokemonList.value = cachedPokemonList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.name.contains(query.trim(), ignoreCase = true) ||
                        it.index.toString() == query.trim()
            }
            if(isSearchStarting) {
                cachedPokemonList = pokemonList.value
                isSearchStarting = false
            }
            pokemonList.value = results
            isSearching.value = true
        }
    }

    fun loadPokemonPaginated(){
        viewModelScope.launch {
            isLoading.value = true
            when(val result = getPokemonListUseCase.invoke(currentPage)) {
                is Resource.Success -> {
                    //endReached.value = currentPage * PAGE_SIZE >= result.data!!.size
                    val pokedexEntries = result.data
                    currentPage++
                    loadError.value = ""
                    isLoading.value = false
                    pokemonList.value += pokedexEntries!!
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
                is Resource.Loading -> {
                    //TODO implement loading behaviour on data layer
                    //ADD delays in repo to simulate this
                }
            }
        }
    }

    private fun calculateDominantColor(drawable: Drawable, onFinished: (Color) -> Unit){
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinished(Color(colorValue))
            }
        }
    }

    fun getImageBackgroundColor(url: String, context: Context, onCalculated: (Color) -> Unit) {
        viewModelScope.launch {
            val req = ImageRequest.Builder(context)
                .data(url)
                .build()
            val result = req.context.imageLoader.execute(req)
            if (result is SuccessResult) {
                calculateDominantColor(result.drawable) { color ->
                    onCalculated(color)
                }
            }
        }
    }

}
