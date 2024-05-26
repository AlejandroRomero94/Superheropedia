package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.response.Biography
import com.alejandro.superheropedia.data.network.response.PowerStatsResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageDetailResponse

data class HeroModel(
    var superheroName:String,
    var superheroStats: PowerStatsResponse,
    var superheroImage: SuperheroImageDetailResponse,
    var superheroBiography: Biography

)