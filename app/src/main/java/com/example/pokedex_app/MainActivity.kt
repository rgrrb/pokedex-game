package com.example.pokedex_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LocalPinnableContainer
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex_app.components.PokemonCard
import com.example.pokedex_app.ui.theme.Pokedex_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pokedex_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    startScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun startScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(220, 10, 45))
                .height(70.dp)
                .padding(24.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.pokeball),
                contentDescription = "Pokedex logo",
                modifier = Modifier.size(30.dp)
            )

            Text(
                "Pokédex", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold
            )
        }

        Column(
            modifier = Modifier
                .padding(24.dp, 0.dp)
                .fillMaxWidth()

        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(0.dp, 8.dp),
                value = "",
                placeholder = {
                    Text(
                        "Nome ou iD",
                        color = Color.Black,
                        fontSize = 15.sp,
                    )
                },
                onValueChange = {},
                trailingIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.searchicon),
                            modifier = Modifier.size(20.dp),
                            contentDescription = "Ícone de pesquisa"
                        )
                    }

                },
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                )
            )
        }
        Column() {
            LazyVerticalGrid(GridCells.Fixed(3),
                modifier = Modifier.padding(24.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)) {

                items(30) { index ->
                    PokemonCard(
                        pokemonImage = painterResource(id = R.drawable.pokeball),
                        pokemonName = "Bulbasaur",
                        pokedexNumber = "#001"
                    )
                }

            }
        }
    }
}