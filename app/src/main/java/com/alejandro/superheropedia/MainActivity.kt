package com.alejandro.superheropedia

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alejandro.superheropedia.ui.dcscreen.DcScreen
import com.alejandro.superheropedia.ui.finderscreen.FinderScreen
import com.alejandro.superheropedia.ui.mainscreen.MainScreen
import com.alejandro.superheropedia.ui.mainscreen.MyTopAppBar
import com.alejandro.superheropedia.ui.marvelscreen.MarvelScreen
import com.alejandro.superheropedia.ui.navigation.MyBottomNavigation
import com.alejandro.superheropedia.ui.theme.SuperheropediaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheropediaTheme {

                MainScreen()


            }

        }
    }


}
