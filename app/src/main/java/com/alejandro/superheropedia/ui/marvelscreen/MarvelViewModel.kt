package com.alejandro.superheropedia.ui.marvelscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.usecase.GetAllHeroesByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel //getAllHeroesByIdUseCase:GetAllHeroesByIdUseCase
class MarvelViewModel @Inject constructor(private val getAllHeroesByIdUseCase: GetAllHeroesByIdUseCase) :
    ViewModel() {
    private val _marvelHeroes = MutableStateFlow<List<HeroModel>>(emptyList())
    val marvelHeroes: StateFlow<List<HeroModel>> get() = _marvelHeroes

    private val _showButtons = MutableStateFlow(true)
    val showButtons: StateFlow<Boolean> get() = _showButtons



    fun getMarvelGoodHeroes() {
        viewModelScope.launch {

            val response =
                withContext(Dispatchers.IO) { getAllHeroesByIdUseCase() }

            if (response.isNotEmpty()) {
                val filteredHeroes = response.filter {
                    it.superheroBiography.publisher == "Marvel Comics" &&
                            it.superheroBiography.alignment == "good"
                }
                _marvelHeroes.value = filteredHeroes
                Log.i(
                    "marvelviewmodel",
                    "Filtered${filteredHeroes.size} heroes"
                )
                Log.i("alex", filteredHeroes.toString())
                _showButtons.value = false

            } else {
                Log.i("MarvelViewModel", "no funciona")
            }


        }}
    fun getMarvelVillains() {
        viewModelScope.launch {

            val response =
                withContext(Dispatchers.IO) { getAllHeroesByIdUseCase() }

            if (response.isNotEmpty()) {
                val filteredHeroes = response.filter {
                    it.superheroBiography.publisher == "Marvel Comics" &&
                            it.superheroBiography.alignment == "bad"
                }
                _marvelHeroes.value = filteredHeroes
                Log.i(
                    "marvelviewmodel",
                    "Filtered${filteredHeroes.size} heroes"
                )
                Log.i("alex", filteredHeroes.toString())
                _showButtons.value = false

            } else {
                Log.i("MarvelViewModel", "no funciona")
            }


        }}


        fun reset() {
            _marvelHeroes.value= emptyList()
            _showButtons.value = true

        }


}