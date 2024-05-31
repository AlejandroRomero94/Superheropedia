package com.alejandro.superheropedia.data

import android.util.Log
import com.alejandro.superheropedia.data.network.SuperheroApiService
import com.alejandro.superheropedia.domain.FilterModel
import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.Repository
import com.alejandro.superheropedia.domain.SuperheroModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val superheroApiService: SuperheroApiService) :
    Repository {

    //getSuperheroes for the finderScreen
    override suspend fun getSuperheroes(superheroName: String): List<SuperheroModel>? {
        runCatching { superheroApiService.getSuperheroes(superheroName) }
            .onSuccess { response -> return response.superheroes?.map { it.toDomain() } }
            .onFailure { Log.i("alex", "Ha ocurrido un error") }
        return null
    }

    //getFilteredSuperheroes for marvel and dc screens
    override suspend fun getFilteredSuperheroes(superheroId: String): FilterModel? {
        return runCatching {
            val response =
                superheroApiService.getSuperheroFiltered(superheroId)
            Log.d("RepositoryImpl", "Response for id $superheroId:$response")
           // response.toDomain()
            FilterModel(superheroName = response.name, superheroImage = response.image, superheroBiography = response.biography )
        }
            .onFailure { e_ ->
                Log.e(
                    "alex",
                    "Ha ocurrido un error en la función del repositoryIMpl"
                )
            }
            .getOrNull()
    }

        override suspend fun getSuperheroDetail(superheroId:String):HeroModel?{
            runCatching { superheroApiService.getSuperheroDetail(superheroId) }
                .onSuccess { response ->return response.toDomain()}
                .onFailure { Log.i("SuperheroImpl", "Ha ocurrido un error") }
                return null
        }
}