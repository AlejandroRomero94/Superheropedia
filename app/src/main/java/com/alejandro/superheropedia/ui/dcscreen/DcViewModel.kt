package com.alejandro.superheropedia.ui.dcscreen

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


@HiltViewModel
class DcViewModel @Inject constructor(private val getAllHeroesByIdUseCase: GetAllHeroesByIdUseCase):
    ViewModel(){

    private val _dcHeroes = MutableStateFlow<List<HeroModel>>(emptyList())
    val dcHeroes: StateFlow<List<HeroModel>> get() = _dcHeroes

    private val _showButtons = MutableStateFlow(true)
    val showButtons: StateFlow<Boolean> get() = _showButtons



    fun getDcHeroes() {
        viewModelScope.launch {

            val response =
                withContext(Dispatchers.IO) { getAllHeroesByIdUseCase() }

            if (response.isNotEmpty()) {
                val filteredHeroes = response.filter {
                    it.superheroBiography.publisher == "DC Comics" &&
                            it.superheroBiography.alignment == "good"
                }
                _dcHeroes.value = filteredHeroes
                Log.i(
                    "dcviewmodel",
                    "Filtered${filteredHeroes.size} heroes"
                )
                Log.i("alex", filteredHeroes.toString())
                _showButtons.value = false

            } else {
                Log.i("DcViewModel", "no funciona")
            }


        }}
    fun getDcVillains() {
        viewModelScope.launch {

            val response =
                withContext(Dispatchers.IO) { getAllHeroesByIdUseCase() }

            if (response.isNotEmpty()) {
                val filteredHeroes = response.filter {
                    it.superheroBiography.publisher == "DC Comics" &&
                            it.superheroBiography.alignment == "bad"
                }
                _dcHeroes.value = filteredHeroes
                Log.i(
                    "dcviewmodel",
                    "Filtered${filteredHeroes.size} heroes"
                )
                Log.i("alex", filteredHeroes.toString())
                _showButtons.value = false

            } else {
                Log.i("DcViewModel", "no funciona")
            }


        }}


    fun reset() {
        _dcHeroes.value= emptyList()
        _showButtons.value = true

    }


}