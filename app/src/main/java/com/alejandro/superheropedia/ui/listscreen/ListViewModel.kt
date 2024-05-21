package com.alejandro.superheropedia.ui.listscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.domain.SuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val superheroUseCase: SuperheroUseCase): ViewModel() {


//aqui tenemos que poner que la variable name va a ser el name que obtengamos del use case






}