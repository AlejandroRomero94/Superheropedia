package com.alejandro.superheropedia.ui.listscreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ListScreen(listState: ListState, listViewModel: ListViewModel) {


    Box(
        Modifier
            .background(Color.Magenta)
            .fillMaxSize()
    ) {

        MyLazyColumn(listState, listViewModel) //Este parentesus es dificil tmbn

    }


}

@Composable
fun MyLazyColumn(listState: ListState, listViewModel: ListViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 6.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
   /*     items() { superhero -> //Hay que resolver el parentesis del items, si es listState o que
            ItemHero(listViewModel = listViewModel)
        }*/

    }
}

@Composable
fun ItemHero(listViewModel: ListViewModel) {
    Card(border = BorderStroke(2.dp, Color.Blue),
        modifier = Modifier
            .width(200.dp)
            .clickable { /*onItemSelected()superhero*/ }) {
        Column {
            AsyncImage(
                model = listViewModel.superhero.superheroImage,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = listViewModel.superhero.superheroName,
                Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

