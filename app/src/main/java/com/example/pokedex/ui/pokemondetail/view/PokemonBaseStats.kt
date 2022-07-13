package com.example.pokedex.ui.pokemondetail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.remote.response.Pokemon
import com.example.pokedex.ui.util.parseStatToAbbr
import com.example.pokedex.ui.util.parseStatToColor

@Composable
fun PokemonBaseStats(
    info: Pokemon,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        info.stats.maxOf { it.base_stat }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Base stats",
            fontSize = 16.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        for(i in info.stats.indices) {
            val stat = info.stats[i]
            PokemonStat(
                statName = parseStatToAbbr(stat),
                statValue = stat.base_stat,
                statMaxValue = maxBaseStat,
                statColor = parseStatToColor(stat),
                animDelay = i * animDelayPerItem
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}