package com.alejandro.superheropedia.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.alejandro.superheropedia.domain.NavigationBarScreen

@Composable
fun RowScope.AddItem(
    screen: NavigationBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    NavigationBarItem(
        label={
            Text(text = screen.title)
        },
        icon={
            Icon(imageVector=screen.icon, contentDescription = "")
        },
        selected = currentDestination?.hierarchy?.any{
            it.route==screen.route
        }==true,
        onClick={
            navController.navigate(screen.route)
        }
    )

}