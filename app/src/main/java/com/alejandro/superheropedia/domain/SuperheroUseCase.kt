package com.alejandro.superheropedia.domain

import javax.inject.Inject

class SuperheroUseCase @Inject constructor(private val repository:Repository){
    suspend operator fun invoke(superheroId:String)=repository.getSuperheroDetail(superheroId)

}