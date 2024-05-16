package com.alejandro.superheropedia.data.network

import com.alejandro.superheropedia.data.network.response.SuperheroDataResponse
import com.alejandro.superheropedia.data.network.response.SuperheroDetailResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroApiService {

    @GET("/api/10227725099851761/search/{name}")
    //corrutina debajo
    suspend fun getSuperheroes(@Path("name")superheroName:String): SuperheroDataResponse
//este valor está en SearchByName






    @GET("/api/10227725099851761/{id}")
   suspend fun getSuperheroDetail(@Path("id") superheroId:String): SuperheroDetailResponse
}
