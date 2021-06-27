package ru.maxdexter.filmapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import ru.maxdexter.filmapp.data.remote_source.MovieService
import ru.maxdexter.filmapp.data.remote_source.api.MovieApi
import javax.inject.Singleton

@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideMovieApi(): MovieApi{
       return MovieService.api
    }
}