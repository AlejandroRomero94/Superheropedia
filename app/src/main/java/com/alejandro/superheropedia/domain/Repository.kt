package com.alejandro.superheropedia.domain

interface Repository {
    suspend fun getSuperheroes(superheroName:String):List<SuperheroModel>?
   suspend fun getFilteredSuperheroes(superheroId:String):FilterModel?

    suspend fun getSuperheroDetail(superheroId:String):HeroModel?

}