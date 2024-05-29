package com.alejandro.superheropedia.ui.finderscreen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.domain.SuperheroModel
import com.alejandro.superheropedia.domain.usecase.SuperheroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel

class FindViewModel @Inject constructor(private val superheroesUseCase: SuperheroesUseCase) :
    ViewModel() {

    private val _searchResults =
        MutableStateFlow<List<SuperheroModel>>(emptyList())
    val searchResults: StateFlow<List<SuperheroModel>> get() = _searchResults

    private val _state = MutableStateFlow<ListState>(ListState.Loading)
    val state: StateFlow<ListState> = _state




    fun searchByName(query: String) {

        viewModelScope.launch {
            val result =
                withContext(Dispatchers.IO) { superheroesUseCase(query) }

            if (result != null) {
                Log.i("alex", result.toString())
                _searchResults.value = result

            } else {
                Log.i("alex", "no funciona")
            }
        }
    }





}