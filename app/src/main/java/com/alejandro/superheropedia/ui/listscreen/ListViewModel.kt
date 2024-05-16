package com.alejandro.superheropedia.ui.listscreen

import androidx.lifecycle.ViewModel
import com.alejandro.superheropedia.domain.SuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val superheroUseCase: SuperheroUseCase): ViewModel() {
}