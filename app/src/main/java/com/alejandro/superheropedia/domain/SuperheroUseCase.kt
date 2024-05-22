package com.alejandro.superheropedia.domain

import com.alejandro.superheropedia.data.network.SuperheroRepository
import com.alejandro.superheropedia.data.network.response.SuperheroItemResponse
import javax.inject.Inject

class SuperheroUseCase @Inject constructor(private val repository:Repository){
    suspend operator fun invoke(superheroName:String)=repository.getSuperheroes(superheroName)
    }

