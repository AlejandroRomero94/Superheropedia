package com.alejandro.superheropedia.ui.finderscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alejandro.superheropedia.domain.SuperheroModel
import com.alejandro.superheropedia.domain.usecase.SuperheroesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel

class FindViewModel @Inject constructor(private val superheroesUseCase: SuperheroesUseCase) :
    ViewModel() {

    private val _searchResults = MutableStateFlow<List<SuperheroModel>>(emptyList())
    val searchResults: StateFlow<List<SuperheroModel>> get() = _searchResults



   // private val _searchResults = MutableLiveData<List<SuperheroModel>?>()
   // val searchResults: MutableLiveData<List<SuperheroModel>?> = _searchResults

    //private val _searchResults = MutableLiveData<String>()
    //var searchResults: LiveData<String> = _searchResults


    private val _state = MutableStateFlow<ListState>(ListState.Loading)
    val state: StateFlow<ListState> = _state

    lateinit var superhero: SuperheroModel
//     var mySuperhero=getSuperheroIdentity()

    var list: List<ListState.Success> = emptyList()


    fun updateList(updateList: List<ListState.Success>) {
        list = updateList
    }


    fun searchByName(query: String) {

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { superheroesUseCase(query) }

            if (result != null) {
                Log.i("alex", result.toString())
                _searchResults.value=result
               // _state.value = ListState.Success(result)

                //  superhero=result.first()
                //  Log.i("alex",superhero.toString())
            } else {
                Log.i("alex", "no funciona")
            }
        }
    }
    /*
     private fun getSuperheroIdentity():Pair<String,String>?{
        return if(::superhero.isInitialized){
            Pair(superhero.superheroName,superhero.superheroImage.url)
        }else{
            null
        }
    }

*/
}