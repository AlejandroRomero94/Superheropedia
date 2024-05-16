package com.alejandro.superheropedia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alejandro.superheropedia.domain.NavigationBarScreen
import com.alejandro.superheropedia.ui.dcscreen.DcScreen
import com.alejandro.superheropedia.ui.finderscreen.FinderScreen
import com.alejandro.superheropedia.ui.listscreen.ListScreen
import com.alejandro.superheropedia.ui.marvelscreen.MarvelScreen


@Composable
fun MyBottomNavigation(navController: NavHostController) {
    //var index by remember { mutableStateOf(0) }
    NavHost(navController = navController, startDestination = NavigationBarScreen.Finder.route) {

        composable(route = NavigationBarScreen.Finder.route) {
            FinderScreen()
        }
        composable(route = NavigationBarScreen.Marvel.route) {
            MarvelScreen(navController=navController)
        }
        composable(route = NavigationBarScreen.Dc.route) {
            DcScreen(navController=navController)
        }
        composable("List"){ ListScreen()}
    }
}
