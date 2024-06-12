package com.alejandro.superheropedia.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.alejandro.superheropedia.R

sealed class NavigationBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {


    object Finder : NavigationBarScreen(
        route = "finder",
        title = "Finder",
        icon = R.drawable.ic_finder,
    )

    object Marvel : NavigationBarScreen(
        route = "marvel",
        title = "Marvel",
        icon = R.drawable.ic_avengers
    )

    object Dc : NavigationBarScreen(
        route = "dc",
        title = "Dc",
        icon = R.drawable.ic_dc
    )



}