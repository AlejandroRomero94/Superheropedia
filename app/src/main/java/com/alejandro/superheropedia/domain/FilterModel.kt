package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.response.Appearance
import com.alejandro.superheropedia.data.network.response.Biography
import com.alejandro.superheropedia.data.network.response.BiographyFilter
import com.alejandro.superheropedia.data.network.response.Connections
import com.alejandro.superheropedia.data.network.response.PowerStatsResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageDetailResponse
import com.alejandro.superheropedia.data.network.response.SuperheroImageFilterResponse
import com.alejandro.superheropedia.data.network.response.Work

data class FilterModel(
    var superheroName:String,
    var superheroBiography: BiographyFilter,
    var superheroImage: SuperheroImageFilterResponse



)