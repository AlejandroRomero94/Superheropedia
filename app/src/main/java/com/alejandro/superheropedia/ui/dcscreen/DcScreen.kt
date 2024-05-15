package com.alejandro.superheropedia.ui.dcscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DcScreen(navController:NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(350.dp)
                    .clickable { navController.navigate("List") }
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text="Heroes")
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(350.dp)
                    .background(Color.Yellow), contentAlignment = Alignment.Center
            ) {
                Text(text="Villains")
            }


        }
    }
}