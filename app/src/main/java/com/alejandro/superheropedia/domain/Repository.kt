package com.alejandro.superheropedia.domain

interface Repository {
    suspend fun getSuperheroes(superheroName:String):List<SuperheroModel>?
    suspend fun getSuperheroDetail(superheroId:String):HeroModel?
}