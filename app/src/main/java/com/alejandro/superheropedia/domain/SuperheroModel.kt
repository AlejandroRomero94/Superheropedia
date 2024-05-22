package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.response.SuperheroImageResponse

data class SuperheroModel(
    var superheroName:String,
    var superheroImage: SuperheroImageResponse
)