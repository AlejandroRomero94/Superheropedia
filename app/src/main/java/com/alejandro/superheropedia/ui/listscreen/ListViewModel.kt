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


//aqui tenemos que poner que la variable name va a ser el name que obtengamos del use case

    private var _state = MutableStateFlow<ListState>(ListState.Loading)
    val state: StateFlow<ListState> = _state

    lateinit var superhero: SuperheroModel

    fun getSuperheroes(superheroName: String) {
        // superhero=superheroName
        viewModelScope.launch {
            _state.value = ListState.Loading
            val result =
                withContext(Dispatchers.IO) { superheroUseCase(superheroName) }
            if (result != null) {
                _state.value = ListState.Success(result)
                superhero = result.first()
            } else {
                _state.value =
                    ListState.Error("Ha ocurrido un error, inténtalo más tarde")
            }
        }


    }
    fun getSuperheroIdentity():Pair<String,String>?{
        return if(::superhero.isInitialized){
            Pair(superhero.superheroName,superhero.superheroImage.url)
        }else{
            null
        }
    }
    val mySuperhero=getSuperheroIdentity()
}