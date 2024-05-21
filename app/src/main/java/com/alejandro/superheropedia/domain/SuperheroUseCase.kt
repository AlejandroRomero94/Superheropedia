package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.SuperheroRepository
import com.alejandro.superheropedia.data.network.response.SuperheroItemResponse
import javax.inject.Inject

class SuperheroUseCase @Inject constructor(private val repository: SuperheroRepository){
    suspend operator fun invoke(superheroName:String): List<SuperheroItemResponse> {
        return repository.getSuperheroes(superheroName)
    }
}

