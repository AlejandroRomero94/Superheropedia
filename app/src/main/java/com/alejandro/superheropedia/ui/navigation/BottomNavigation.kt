package com.alejandro.superheropedia.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alejandro.superheropedia.domain.NavigationBarScreen
import com.alejandro.superheropedia.ui.dcscreen.DcScreen
import com.alejandro.superheropedia.ui.dcscreen.DcViewModel
import com.alejandro.superheropedia.ui.detailscreen.DetailScreen
import com.alejandro.superheropedia.ui.detailscreen.DetailViewModel
import com.alejandro.superheropedia.ui.finderscreen.FindViewModel
import com.alejandro.superheropedia.ui.finderscreen.FinderScreen
import com.alejandro.superheropedia.ui.marvelscreen.MarvelScreen
import com.alejandro.superheropedia.ui.marvelscreen.MarvelViewModel


@Composable
fun MyBottomNavigation(
    navController: NavHostController,
    innerPadding: PaddingValues
) {

    val findViewModel: FindViewModel = hiltViewModel()
    val marvelViewModel: MarvelViewModel = hiltViewModel()
    val dcViewModel: DcViewModel = hiltViewModel()
    val detailViewModel: DetailViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = NavigationBarScreen.Finder.route,
        modifier = Modifier.padding(innerPadding)
    ) {

        composable(route = NavigationBarScreen.Finder.route) {

            FinderScreen(
                findViewModel,
                navController = navController
            ) { superheroId ->
                detailViewModel.loadSuperheroDetails(superheroId)
                navController.navigate("Detail/$superheroId")
            }
        }
        composable(route = NavigationBarScreen.Marvel.route) {
            MarvelScreen(marvelViewModel)
        }
        composable(route = NavigationBarScreen.Dc.route) {
            DcScreen(dcViewModel)
        }
        composable(
            "Detail/{superheroId}",
            arguments = listOf(navArgument("superheroId") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            val superheroId =
                navBackStackEntry.arguments?.getString("superheroId")
            if (superheroId != null) {
                DetailScreen(detailViewModel, superheroId)
            }
        }
    }
}

