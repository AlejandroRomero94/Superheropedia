package com.alejandro.superheropedia.ui.finderscreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alejandro.superheropedia.data.network.response.SuperheroItemResponse
import com.alejandro.superheropedia.domain.SuperheroModel
import com.alejandro.superheropedia.domain.SuperheroUseCase
import com.alejandro.superheropedia.ui.listscreen.ListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel

class FindViewModel @Inject constructor(private val superheroUseCase: SuperheroUseCase):ViewModel(){



    private val _searchResults =MutableLiveData<String>()
    var searchResults:LiveData<String> = _searchResults


    private val _state = MutableStateFlow<ListState>(ListState.Loading)
 //   val state: StateFlow<ListState> = _state

    lateinit var superhero: SuperheroModel
//     var mySuperhero=getSuperheroIdentity()

     var list:List<ListState> = emptyList()


fun searchByName(query:String){

    viewModelScope.launch {
        val result= withContext(Dispatchers.IO){superheroUseCase(query)}

        if (result!=null){
            Log.i("alex",result.toString())
            _state.value=ListState.Success(result)
            superhero=result.first()
        }else{
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