package com.alejandro.superheropedia.ui.marvelscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.alejandro.superheropedia.domain.HeroModel


@Composable
fun MarvelScreen(marvelViewModel: MarvelViewModel) {

    val heroes by marvelViewModel.marvelHeroes.collectAsState()
    val showButtons by marvelViewModel.showButtons.collectAsState()

    if (showButtons) {
        ButtonScreen(onHeroesButtonClick = {
            marvelViewModel.getMarvelGoodHeroes()
        },
            onVillainsButtonClick = {
                marvelViewModel.getMarvelVillains()
            })
    } else {
        if (heroes.isNotEmpty()) {
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {

                items(heroes) { hero ->
                    MarvelSuperheroItem(hero = hero)
                }
            }
        } else {
            Text(text = "No heroes found")
        }
    }
}


@Composable
fun ButtonScreen(
    onHeroesButtonClick: () -> Unit,
    onVillainsButtonClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Button(
            onClick = onHeroesButtonClick,
            modifier = Modifier
                .background(Color.Black)
                .height(200.dp)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Marvel Heroes", fontSize=30.sp)
        }

        Button(
            onClick = onVillainsButtonClick,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ) {
            Text(text = "Marvel Villains", fontSize=30.sp)
        }
    }
}


@Composable
fun MarvelSuperheroItem(hero: HeroModel) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter(hero.superheroImage.url),
                contentDescription = hero.superheroName,
                modifier = Modifier
                    .size(84.dp)
                    .padding(8.dp)
                    .clip(
                        RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = hero.superheroName)
        }
    }

}








