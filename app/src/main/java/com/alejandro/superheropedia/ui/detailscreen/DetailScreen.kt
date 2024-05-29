package com.alejandro.superheropedia.ui.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel, superheroId: String
) {


    val superheroDetail by detailViewModel.getSuperhero.observeAsState()

    if (superheroDetail != null) {

        superheroDetail?.let { superhero ->

            Card(modifier = Modifier.fillMaxSize()) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)

                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterHorizontally)
                    ) {


                        Image(
                            painter = rememberAsyncImagePainter(superhero.superheroImage.url),
                            contentDescription = "",
                            modifier = Modifier

                                .clip(
                                    RoundedCornerShape(corner = CornerSize(16.dp))
                                )
                                .fillMaxHeight(),
                            contentScale = ContentScale.Crop
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    LazyColumn(modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)) {
                        item {
                            Text(
                                text = superhero.superheroName,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 30.sp
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Full name: ")
                                    }
                                    append(superhero.superheroBiography.fullName)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Aliases: ")
                                    }
                                    append(
                                        superhero.superheroBiography.aliases.joinToString(
                                            ", "
                                        )
                                    )
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Alter egos: ")
                                    }

                                    append(superhero.superheroBiography.alterEgos)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Birth place: ")
                                    }
                                    append(superhero.superheroBiography.placeOfBirth)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("First Appearance: ")
                                    }
                                    append(superhero.superheroBiography.firstAppearance)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Alignment: ")
                                    }
                                    append(superhero.superheroBiography.alignment)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Publisher: ")
                                    }
                                    append(superhero.superheroBiography.publisher)

                                }
                            )
                        }
                      item  { Spacer(modifier = Modifier.height(16.dp)) }

                        item {
                            Text(text = "Physical description", fontWeight = FontWeight.ExtraBold)
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Gender: ")
                                    }
                                    append(superhero.superheroAppearance.gender)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Race: ")
                                    }
                                    append(superhero.superheroAppearance.race)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Height: ")
                                    }
                                    append(
                                        superhero.superheroAppearance.height.joinToString(
                                            " / "
                                        )
                                    )
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Weight: ")
                                    }
                                    append(
                                        superhero.superheroAppearance.weight.joinToString(
                                            " / "
                                        )
                                    )
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Eye color: ")
                                    }
                                    append(superhero.superheroAppearance.eyeColor)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Hair color: ")
                                    }
                                    append(superhero.superheroAppearance.hairColor)
                                }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            Text(text = "Occupation and base", fontWeight = FontWeight.ExtraBold)
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Occupation: ")
                                    }
                                    append(superhero.superheroWork.occupation)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Base: ")
                                    }
                                    append(superhero.superheroWork.base)
                                }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            Text(text = "Known affiliations", fontWeight = FontWeight.ExtraBold)
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Groups: ")
                                    }
                                    append(superhero.superheroConnections.groupAffiliation)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append("Relatives: ")
                                    }
                                    append(superhero.superheroConnections.relatives)
                                }
                            )
                        }
                    }

                }
            }
        }
    }
}




