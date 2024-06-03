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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.alejandro.superheropedia.R


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
                                        append(stringResource(id = R.string.full_name))
                                    }
                                    append(superhero.superheroBiography.fullName)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.aliases))
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
                                        append(stringResource(id = R.string.alter_egos))
                                    }

                                    append(superhero.superheroBiography.alterEgos)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.birth))
                                    }
                                    append(superhero.superheroBiography.placeOfBirth)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.first_appearance))
                                    }
                                    append(superhero.superheroBiography.firstAppearance)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.alignement))
                                    }
                                    append(superhero.superheroBiography.alignment)

                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.publisher))
                                    }
                                    append(superhero.superheroBiography.publisher)

                                }
                            )
                        }
                      item  { Spacer(modifier = Modifier.height(16.dp)) }

                        item {
                            Text(text = stringResource(id = R.string.physical_description), fontWeight = FontWeight.ExtraBold)
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.gender))
                                    }
                                    append(superhero.superheroAppearance.gender)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.race))
                                    }
                                    append(superhero.superheroAppearance.race)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.height))
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
                                        append(stringResource(id = R.string.weight))
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
                                        append(stringResource(id = R.string.eye_color))
                                    }
                                    append(superhero.superheroAppearance.eyeColor)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.hair_color))
                                    }
                                    append(superhero.superheroAppearance.hairColor)
                                }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            Text(text = stringResource(id = R.string.occupation_base), fontWeight = FontWeight.ExtraBold)
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.occupation))
                                    }
                                    append(superhero.superheroWork.occupation)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.base))
                                    }
                                    append(superhero.superheroWork.base)
                                }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                        item {
                            Text(text = stringResource(id = R.string.affiliations), fontWeight = FontWeight.ExtraBold)
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.groups))
                                    }
                                    append(superhero.superheroConnections.groupAffiliation)
                                }
                            )
                        }
                        item {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                        append(stringResource(id = R.string.relatives))
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




