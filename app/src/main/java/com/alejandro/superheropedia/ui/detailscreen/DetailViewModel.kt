package com.alejandro.superheropedia.ui.detailscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.usecase.SuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val superheroUseCase: SuperheroUseCase) :
    ViewModel() {


    private val _getSuperhero = MutableLiveData<HeroModel?>()
    val getSuperhero: LiveData<HeroModel?> get() = _getSuperhero

    fun loadSuperheroDetails(superheroId: String) {
        viewModelScope.launch {
            val result =
                withContext(Dispatchers.IO) { superheroUseCase(superheroId) }

            result?.let{
                Log.i("DetailViewModel",result.toString())
                _getSuperhero.value=result
            }
        }


    }


}