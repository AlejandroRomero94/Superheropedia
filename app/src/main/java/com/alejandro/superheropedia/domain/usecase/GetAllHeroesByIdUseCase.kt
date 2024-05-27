package com.alejandro.superheropedia.domain.usecase

import android.util.Log
import android.widget.Toast
import androidx.compose.material3.Text
import com.alejandro.superheropedia.domain.HeroModel
import com.alejandro.superheropedia.domain.Repository
import com.alejandro.superheropedia.domain.SuperheroModel
import javax.inject.Inject

class GetAllHeroesByIdUseCase @Inject constructor(private val repository: Repository){
    suspend operator fun invoke():MutableList<HeroModel>{

        val superheroes= mutableListOf<HeroModel>()
        for (id in 1..731){
            try {
                val response = repository.getFilteredSuperheroes(id.toString())
                if (response != null) {
                    superheroes.add(response)
                }else{
                    Log.i("GetAllheroesByIdUseCase", "No heroes found for id $id")
            }
            }catch (e:Exception){
               Log.e("Getallheroesbyidusecase", "Error fetching hero with id $id",e)
            }
        }
        Log.i("getallheroesbyidusecase", "fetched ${superheroes.size} heroes")
        return superheroes


    }

}