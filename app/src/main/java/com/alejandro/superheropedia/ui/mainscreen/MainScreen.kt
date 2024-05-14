package com.alejandro.superheropedia.ui.mainscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alejandro.superheropedia.model.NavigationBarScreen
import com.alejandro.superheropedia.ui.navigation.MyBottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(

) {

    val navController = rememberNavController()

    /*
    NavHost(navController = navigationController, startDestination="finder"){
        composable("finder"){ FinderScreen(navigationController) }
        composable("marvel"){ MarvelScreen(navigationController) }
        composable("dc"){ DcScreen(navigationController) }


    }

*/

    Scaffold(
        topBar = { MyTopAppBar() },
        bottomBar = { NavigationBar(navController = navController)}

        ) {


        MyBottomNavigation(navController = navController)

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
        screens.forEach{screen->
AddItem(screen = screen, currentDestination = currentDestination, navController =navController )
    }



    }
}
@Composable
fun RowScope.AddItem(
    screen:NavigationBarScreen,
    currentDestination: NavDestination?,
    navController:NavHostController
){

    NavigationBarItem(
        label={
            Text(text = screen.title)},
        icon={
            Icon(imageVector=screen.icon, contentDescription = "")},
        selected = currentDestination?.hierarchy?.any{
            it.route==screen.route
        }==true,
onClick={
    navController.navigate(screen.route)
}
    )

}
/*
    NavigationBar(
        containerColor = Color.Gray, contentColor = Color.White,
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = {
                index = 0
                navController.navigate(NavigationBarScreen.Finder.route)
            },
            icon = {
                Icon(
                    imageVector = NavigationBarScreen.Finder.icon,
                    contentDescription = "finder"
                )
            }, label =
            { Text(text = NavigationBarScreen.Finder.title) })
        NavigationBarItem(
            selected = index == 1,
            onClick = {
                index = 1
                navController.navigate(NavigationBarScreen.Marvel.route)
            },
            icon = {
                Icon(
                    imageVector = NavigationBarScreen.Marvel.icon,
                    contentDescription = "marvel"
                )
            }, label = { Text(text = NavigationBarScreen.Marvel.title) })
        NavigationBarItem(
            selected = index == 2,
            onClick = {
                index = 2
                navController.navigate(NavigationBarScreen.Dc.route)
            },
            icon = {
                Icon(
                    imageVector = NavigationBarScreen.Dc.icon,
                    contentDescription = "dc"
                )
            }, label = { Text(text = NavigationBarScreen.Dc.title) })
    }
}
*/