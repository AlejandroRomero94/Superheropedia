package com.alejandro.superheropedia.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {


    object Finder : NavigationBarScreen(
        route = "finder",
        title = "Finder",
        icon = Icons.Default.Search
    )

    object Marvel : NavigationBarScreen(
        route = "marvel",
        title = "Marvel",
        icon = Icons.Default.Star
    )

    object Dc : NavigationBarScreen(
        route = "dc",
        title = "Dc",
        icon = Icons.Default.Person
    )



}