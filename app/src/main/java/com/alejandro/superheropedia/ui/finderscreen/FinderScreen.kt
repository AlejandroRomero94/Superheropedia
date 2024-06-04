package com.alejandro.superheropedia.ui.finderscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.alejandro.superheropedia.data.network.response.BiographyResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageResponse
import com.alejandro.superheropedia.domain.SuperheroModel

@Composable
fun FinderScreen(findViewModel: FindViewModel, navController: NavHostController, onItemSelected:(String)->Unit) {
    val searchResults by findViewModel.searchResults.collectAsState()
    FinderScreenContent(searchResults, findViewModel::searchByName, navController, onItemSelected)
}

@Composable
fun FinderScreenContent(heroList: List<SuperheroModel>,  onSearch: (String) -> Unit, navController: NavHostController, onItemSelected:(String)->Unit) {
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
            HeroSearchBar(onSearch)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .weight(5f)
        ) {
            SuperheroList(heroList, navController,onItemSelected)
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun SuperheroList(heroList: List<SuperheroModel>, navController: NavHostController,onItemSelected:(String)->Unit ) {
        LazyColumn {
        items(heroList) { superhero ->
            SuperheroItem(superhero, navController, onItemSelected)
        }
    }
}

@Composable
fun SuperheroItem(superhero: SuperheroModel, navController: NavHostController, onItemSelected:(String)->Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                onItemSelected(superhero.superheroesId)
                navController.navigate("Detail/${superhero.superheroesId}")
            },
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(superhero.superheroesImage.url),
                contentDescription = superhero.superheroesName,
                modifier = Modifier
                    .size(84.dp)
                    .padding(8.dp)
                    .clip(
                        RoundedCornerShape(corner = CornerSize(16.dp))
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = superhero.superheroesName)
        }
    }
}

@Composable
fun HeroSearchBar(
    onSearch: (String) -> Unit
) {

    var text: String by remember {
        mutableStateOf("")
    }

    TextField(
        value = text,
        singleLine = true,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text(text = "find") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            onSearch(text)
        })
    )
}

@Preview(showBackground = true)
@Composable
fun FinderScreenContentPreview() {
    val navController = rememberNavController()
    val dummyHeroList = listOf(
        SuperheroModel(
            superheroesName = "Superman",
            superheroesImage = SuperheroImageResponse("url"),
            superheroBiography = BiographyResponse("1980", "good"),
            superheroesId = "1"
        ),
        SuperheroModel(
            superheroesName = "Batman",
            superheroesImage = SuperheroImageResponse("url"),
            superheroBiography = BiographyResponse("1980", "good"),
            superheroesId = "2"
        )
    )
    FinderScreenContent(
        heroList = dummyHeroList,
        navController = navController,
        onItemSelected = {},
        onSearch = {}
    )
}