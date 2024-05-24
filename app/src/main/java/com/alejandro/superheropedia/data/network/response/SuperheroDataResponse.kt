package com.alejandro.superheropedia.data.network.response

import com.alejandro.superheropedia.domain.SuperheroModel
import com.google.gson.annotations.SerializedName

data class SuperheroDataResponse(
    @SerializedName("response") val response:String,
    @SerializedName("results") val superheroes:List<SuperheroItemResponse>

)

data class SuperheroItemResponse(
    @SerializedName("id") val superheroId:String,
    @SerializedName("name") val superheroName:String,
    @SerializedName("image") val superheroImage:SuperheroImageResponse
)
{
    fun toDomain():SuperheroModel{
        return SuperheroModel(
            superheroesName=superheroName,
            superheroesImage=superheroImage
        )
    }
}

data class SuperheroImageResponse(@SerializedName("url") val url:String)
