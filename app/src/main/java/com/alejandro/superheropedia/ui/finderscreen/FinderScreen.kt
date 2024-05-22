package com.alejandro.superheropedia.ui.finderscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable

fun FinderScreen(findViewModel: FindViewModel) {

Column(modifier = Modifier.fillMaxSize()) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .padding(top = 16.dp)
            .weight(1f)
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        HeroSearchBar(findViewModel) {}

    }
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue).weight(5f)){
        SuperLazyColumn()
    }
}



}






@Composable
fun HeroSearchBar(
    findViewModel: FindViewModel,
    onTextChanged: (String) -> Unit
) {

    var text: String by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        onValueChange = { newText->
                        text=newText
            onTextChanged(newText)
        },
        label = { Text(text = "find") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {findViewModel.searchByName(text)})

)

}








