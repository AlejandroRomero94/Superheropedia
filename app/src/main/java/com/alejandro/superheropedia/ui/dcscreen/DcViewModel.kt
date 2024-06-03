package com.alejandro.superheropedia.ui.dcscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.R
import com.alejandro.superheropedia.domain.FilterModel
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

    private val _dcHeroes = MutableStateFlow<List<FilterModel>>(emptyList())
    val dcHeroes: StateFlow<List<FilterModel>> get() = _dcHeroes

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
                    "DcViewModel",
                    "Filtered${filteredHeroes.size} heroes"
                )
                Log.i("DcViewModel", filteredHeroes.toString())
                _showButtons.value = false

            } else {
                Log.i("DcViewModel", R.string.no_values.toString())
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
                    "DcViewModel",
                    "Filtered${filteredHeroes.size} heroes"
                )
                Log.i("alex", filteredHeroes.toString())
                _showButtons.value = false

            } else {
                Log.i("DcViewModel", R.string.no_values.toString())
            }


        }}


}
