package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.response.Appearance
import com.alejandro.superheropedia.data.network.response.Biography
import com.alejandro.superheropedia.data.network.response.Connections
import com.alejandro.superheropedia.data.network.response.PowerStatsResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageDetailResponse
import com.alejandro.superheropedia.data.network.response.Work

data class HeroModel(
    var superheroName:String,
    var superheroStats: PowerStatsResponse,
    var superheroImage: SuperheroImageDetailResponse,
    var superheroBiography: Biography,
    var superheroAppearance:Appearance,
    var superheroWork: Work,
    var superheroConnections: Connections
)