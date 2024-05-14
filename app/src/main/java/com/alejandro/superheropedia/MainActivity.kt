package com.alejandro.superheropedia

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.alejandro.superheropedia.ui.mainscreen.MainScreen
import com.alejandro.superheropedia.ui.mainscreen.MainScreenViewModel
import com.alejandro.superheropedia.ui.mainscreen.MyTopAppBar
import com.alejandro.superheropedia.ui.navigation.MyBottomNavigation
import com.alejandro.superheropedia.ui.theme.SuperheropediaTheme
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheropediaTheme {
            Scaffold(
                topBar = {MyTopAppBar()},
                bottomBar = { MyBottomNavigation()}
            ){
                val padding=it
            }

                /*Surface {
                    MyTopAppBar()
                    MyBottomNavigation()
                }*/

               // Scaffold { innerPadding ->


            }

        }
    }




}
