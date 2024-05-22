package com.alejandro.superheropedia.ui.mainscreen

import android.annotation.SuppressLint
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alejandro.superheropedia.domain.NavigationBarScreen
import com.alejandro.superheropedia.ui.navigation.AddItem
import com.alejandro.superheropedia.ui.navigation.MyBottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(
        topBar = { MyTopAppBar() },
        bottomBar = { NavigationBar(navController = navController)}

        ) {innerPadding->
        MyBottomNavigation(navController = navController, innerPadding=innerPadding)
    }
}


@Composable
fun NavigationBar(navController: NavHostController) {
    val screens = listOf(
        NavigationBarScreen.Finder,
        NavigationBarScreen.Marvel,
        NavigationBarScreen.Dc
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }

    }
}
