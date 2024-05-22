package com.alejandro.superheropedia.data

import android.util.Log
import com.alejandro.superheropedia.data.network.SuperheroApiService
import com.alejandro.superheropedia.domain.Repository
import com.alejandro.superheropedia.domain.SuperheroModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor (private val superheroApiService:SuperheroApiService):
    Repository {
        override suspend fun getSuperheroes(superheroName:String): List<SuperheroModel>?{
            runCatching{superheroApiService.getSuperheroes(superheroName)}
                .onSuccess { response ->return response.superheroes.map{it.toDomain()} }
                .onFailure { Log.i("alex", "Ha ocurrido un error") }
            return null
        }

}