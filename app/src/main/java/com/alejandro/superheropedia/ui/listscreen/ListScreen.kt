package com.alejandro.superheropedia.ui.listscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alejandro.superheropedia.data.network.SuperheroApiService
import retrofit2.Retrofit


@Preview
@Composable
fun ListScreen(){

    Box (
        Modifier
            .background(Color.Magenta)
            .fillMaxSize()){

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(vertical = 4.dp, horizontal = 6.dp),
            verticalArrangement = Arrangement.spacedBy(space=8.dp)
        ) {






        }


    }
}