package com.alejandro.superheropedia.data.network

import com.alejandro.superheropedia.data.network.response.SuperheroDetailResponse
import com.alejandro.superheropedia.data.network.response.SuperheroItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
/*
class Service @Inject constructor(private val superheroApiService:SuperheroApiService){


    suspend fun getSuperheroes(superheroName:String): List<SuperheroItemResponse> {
        return withContext(Dispatchers.IO){
            val response=superheroApiService.getSuperheroes(superheroName)
            response.superheroes
        }
    }
    //Prueba
    suspend fun getSuperheroDetail(superheroId:String):SuperheroDetailResponse {
return withContext(Dispatchers.IO){
    val responseHero=superheroApiService.getSuperheroDetail(superheroId)
    responseHero
}
    }

}

   /*suspend fun getSuperheroes(superheroName:String): List<SuperheroItemResponse> {
      return  withContext(Dispatchers.IO) {
            val response = superheroApiService.getSuperheroes(superheroName)
response.superheroes
        }}*/
*/