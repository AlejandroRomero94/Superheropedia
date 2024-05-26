package com.alejandro.superheropedia.domain.usecase

import com.alejandro.superheropedia.domain.Repository
import javax.inject.Inject

class SuperheroesUseCase @Inject constructor(private val repository: Repository){
    suspend operator fun invoke(superheroName:String)=repository.getSuperheroes(superheroName)

    }

