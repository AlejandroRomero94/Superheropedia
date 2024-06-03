package com.alejandro.superheropedia.ui.mainscreen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.alejandro.superheropedia.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){
    val powerFontFamily= FontFamily(Font(R.font.power))
    TopAppBar(title = { Text(text = stringResource(id = R.string.app_name), fontFamily = powerFontFamily, textAlign = TextAlign.Center) })
}