package com.alejandro.superheropedia.ui.marvelscreen

import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.SuperheroModel

sealed class MarvelState {

        data object Loading: MarvelState()
        data class Error (val error:String): MarvelState()
        data class Success(val superheroes:List<HeroModel>): MarvelState()
    }