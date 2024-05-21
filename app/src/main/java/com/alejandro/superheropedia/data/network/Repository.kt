package com.alejandro.superheropedia.data.network

import com.alejandro.superheropedia.data.network.response.SuperheroItemResponse
import javax.inject.Inject

class SuperheroRepository @Inject constructor(private val service:Service){

    suspend fun getSuperheroes(superheroName:String): List<SuperheroItemResponse> {
        return service.getSuperheroes(superheroName)
    }
}