package com.alejandro.superheropedia.ui.listscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.domain.SuperheroModel
import com.alejandro.superheropedia.domain.SuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val superheroUseCase: SuperheroUseCase) :
    ViewModel() {

    }