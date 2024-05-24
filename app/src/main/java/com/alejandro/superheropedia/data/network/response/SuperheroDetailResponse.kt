package com.alejandro.superheropedia.data.network.response

import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.SuperheroModel
import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography")val biography:Biography
)
{
    fun toDomain(): HeroModel {
        return HeroModel(
            superheroName=name,
            superheroStats=powerstats,
            superheroImage=image,
            superheroBiography=biography
        )
    }
}

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class SuperheroImageDetailResponse(@SerializedName("url") val url: String)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("alignment") val alignment: String
)
