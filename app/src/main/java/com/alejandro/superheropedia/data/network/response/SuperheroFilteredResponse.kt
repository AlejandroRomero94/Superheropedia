package com.alejandro.superheropedia.data.network.response

import com.alejandro.superheropedia.domain.FilterModel
import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.SuperheroModel
import com.google.gson.annotations.SerializedName

data class SuperheroFilteredResponse(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: SuperheroImageFilterResponse,
    @SerializedName("biography")val biography:BiographyFilter,

)
{
    fun toDomain(): FilterModel {
        return FilterModel(
            superheroName=name,
            superheroImage=image,
            superheroBiography=biography,
        )
    }
}


data class SuperheroImageFilterResponse(@SerializedName("url") val url: String)

data class BiographyFilter(
    @SerializedName("publisher") val publisher: String,
    @SerializedName("alignment") val alignment: String
)

