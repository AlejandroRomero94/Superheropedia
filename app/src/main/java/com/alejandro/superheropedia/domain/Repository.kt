package com.alejandro.superheropedia.domain

interface Repository {
    suspend fun getSuperheroes(superheroName:String):List<SuperheroModel>?
}