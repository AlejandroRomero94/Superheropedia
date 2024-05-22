package com.alejandro.superheropedia.ui.listscreen

import com.alejandro.superheropedia.domain.SuperheroModel

sealed class ListState {
    data object Loading:ListState()
    data class Error (val error:String):ListState()
    data class Success(val superheroes:List<SuperheroModel>):ListState()
}