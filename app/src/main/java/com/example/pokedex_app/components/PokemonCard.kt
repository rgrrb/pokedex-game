package com.example.pokedex_app.components

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

val PokemonCardGreen = Color(0xFF8DC65F)

val PokemonCardInnerBorder = Color(0xFFE0E0E0)

val PlaceholderBackground = Color(0xFFF0F0F0)


@Composable
fun PokemonCard(
    pokemonImage: Painter,
    pokemonName: String,
    pokedexNumber: String,
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
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                    Text(
                        text = pokedexNumber,
                        color = PokemonCardInnerBorder.copy(alpha = 0.6f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(end = 12.dp, top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .size(160.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(PlaceholderBackground),
                    contentAlignment = Alignment.Center
                ) {

                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Placeholder",
                        tint = PokemonCardInnerBorder,
                        modifier = Modifier.size(64.dp)
                    )
                }
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
