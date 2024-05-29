package com.alejandro.superheropedia.domain

interface Repository {
    suspend fun getSuperheroes(superheroName:String):List<SuperheroModel>?
   suspend fun getFilteredSuperheroes(superheroId:String):HeroModel?

    suspend fun getSuperheroDetail(superheroId:String):HeroModel?

}