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
import com.alejandro.superheropedia.ui.mainscreen.MainScreen
import com.alejandro.superheropedia.ui.mainscreen.MainScreenViewModel
import com.alejandro.superheropedia.ui.mainscreen.MyTopAppBar
import com.alejandro.superheropedia.ui.mainscreen.navigation.MyBottomNavigation
import com.alejandro.superheropedia.ui.theme.SuperheropediaTheme
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheropediaTheme {
            ViewContainer()

                /*Surface {
                    MyTopAppBar()
                    MyBottomNavigation()
                }*/

               // Scaffold { innerPadding ->


            }

        }
    }

    private fun Scaffold(bottomBar: () -> Unit) {

    }
}

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewContainer(){
    Scaffold(
        topBar = { MyTopAppBar()}, content={ MainScreen(MainScreenViewModel()) }, bottomBar = { MyBottomNavigation()})

}
