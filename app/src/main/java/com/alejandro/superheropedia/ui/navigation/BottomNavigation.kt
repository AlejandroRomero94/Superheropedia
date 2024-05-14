package com.alejandro.superheropedia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alejandro.superheropedia.model.NavigationBarScreen
import com.alejandro.superheropedia.ui.dcscreen.DcScreen
import com.alejandro.superheropedia.ui.finderscreen.FinderScreen
import com.alejandro.superheropedia.ui.marvelscreen.MarvelScreen


@Composable
fun MyBottomNavigation(navController: NavHostController) {
    //var index by remember { mutableStateOf(0) }
    NavHost(navController = navController, startDestination = NavigationBarScreen.Finder.route) {

        composable(route = NavigationBarScreen.Finder.route) {
            FinderScreen()
        }
        composable(route = NavigationBarScreen.Marvel.route) {
            MarvelScreen()
        }
        composable(route = NavigationBarScreen.Dc.route) {
            DcScreen()
        }
    }
}
/*
    NavigationBar(
        containerColor = Color.Gray, contentColor = Color.White,
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = {
                index = 0
                navController.navigate("finder")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            }, label =
            { Text(text = "Finder") })
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1
                navController.navigate("marveld")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "marvel"
                )
            }, label = { Text(text = "Marvel") })
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
                navController.navigate("dc")
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "dc"
                )
            }, label = { Text(text = "DC") })
    }

}*/