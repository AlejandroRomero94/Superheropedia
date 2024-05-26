package com.alejandro.superheropedia.data

import android.util.Log
import com.alejandro.superheropedia.data.network.SuperheroApiService
import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.Repository
import com.alejandro.superheropedia.domain.SuperheroModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val superheroApiService: SuperheroApiService) :
    Repository {
    override suspend fun getSuperheroes(superheroName: String): List<SuperheroModel>? {
        runCatching { superheroApiService.getSuperheroes(superheroName) }
            .onSuccess { response -> return response.superheroes?.map { it.toDomain() } }
            .onFailure { Log.i("alex", "Ha ocurrido un error") }
        return null
    }

    override suspend fun getFilteredSuperheroes(superheroId:String):HeroModel?{
       return runCatching{
           val response=superheroApiService.getSuperheroFilteredList(superheroId)
       Log.d("RepositoryImpl", "Response for id $superheroId:$response")
           response.toDomain()}
            .onFailure { e_->
                Log.e("alex", "Ha ocurrido un error en la función del repositoryIMpl") }
           .getOrNull()
    }
    /* Este de abajo es el que me manda errores. Arriba según lo dice chatgpt
    override suspend fun getFilteredSuperheroes(superheroId:String):List<SuperheroModel>?{
        runCatching{superheroApiService.getSuperheroFilteredList(superheroId)}
            .onSuccess { response ->
                return response.superheroes.map{it.toDomain()}?: emptyList()
            }
            .onFailure { Log.i("alex", "Ha ocurrido un error en la función del repositoryIMpl") }
        return null
    }*/

    /*
        override suspend fun getSuperheroDetail(superheroId:String):HeroModel?{
            runCatching { superheroApiService.getSuperheroDetail(superheroId) }
                .onSuccess { response ->return response.toDomain()}
                .onFailure { Log.i("alex", "Ha ocurrido un error") }
                return null
        }
        */

}