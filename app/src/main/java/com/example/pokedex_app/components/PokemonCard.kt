package com.example.pokedex_app.components

import android.R.attr.contentDescription
import android.R.attr.name
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import coil.compose.AsyncImage

val PokemonCardGreen = Color(0xFF8DC65F)


@Composable
fun PokemonCard(
    pokemonImage: String,
    pokemonName: String,
    pokemonNumber: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(150.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color.White)
            .border(width = 2.dp, color = PokemonCardGreen, shape = RoundedCornerShape(6.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                    Text(
                        text = pokemonNumber,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light
                    )
                }

                AsyncImage(
                    model = pokemonImage,
                    contentDescription = pokemonName,
                    modifier = Modifier.fillMaxSize()
                )

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .background(PokemonCardGreen),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = pokemonName,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
