package com.alejandro.superheropedia.data.network.response

import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.SuperheroModel
import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("image") val image: SuperheroImageDetailResponse,
    @SerializedName("biography")val biography:Biography,
    @SerializedName("appearance") val appearance:Appearance,
    @SerializedName ("work") val work:Work,
    @SerializedName ("connections") val connections:Connections,
)
{
    fun toDomain(): HeroModel {
        return HeroModel(
            superheroName=name,
            superheroStats=powerstats,
            superheroImage=image,
            superheroBiography=biography,
            superheroAppearance=appearance,
            superheroWork=work,
            superheroConnections=connections
        )
    }
}


data class Connections(
    @SerializedName ("group-affiliation") val groupAffiliation:String,
    @SerializedName ("relatives") val relatives:String
)


data class Work(
    @SerializedName ("occupation") val occupation:String,
    @SerializedName ("base") val base:String
)

data class Appearance(
    @SerializedName ("gender") val gender:String,
    @SerializedName ("race") val race:String,
    @SerializedName ("height") val height:List<String>,
    @SerializedName ("weight") val weight:List<String>,
    @SerializedName ("eye-color") val eyeColor:String,
    @SerializedName ("hair-color") val hairColor:String

)

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
    @SerializedName("alter-egos") val alterEgos:String,
    @SerializedName ("aliases") val aliases:List<String>,
    @SerializedName ("place-of-birth") val placeOfBirth:String,
    @SerializedName ("first-appearance") val firstAppearance:String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("alignment") val alignment: String
)

