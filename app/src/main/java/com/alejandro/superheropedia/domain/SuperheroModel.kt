package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.response.Biography
import com.alejandro.superheropedia.data.network.response.BiographyResponse
import com.alejandro.superheropedia.data.network.response.PowerStatsResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageDetailResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageResponse

data class SuperheroModel(
    var superheroesName:String,
    var superheroesImage: SuperheroImageResponse,
    var superheroBiography:BiographyResponse,
    var superheroesId:String

    )