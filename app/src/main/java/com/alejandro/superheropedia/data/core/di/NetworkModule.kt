package com.alejandro.superheropedia.data.core.di

import com.alejandro.superheropedia.data.RepositoryImpl
import com.alejandro.superheropedia.data.network.SuperheroApiService
import com.alejandro.superheropedia.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideRetrofit (): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    fun provideSuperheroApiService(retrofit:Retrofit):SuperheroApiService{
        return retrofit.create(SuperheroApiService::class.java)
    }

    @Provides
    fun provideRepository(superheroApiService: SuperheroApiService):Repository{
        return RepositoryImpl(superheroApiService)
    }

}