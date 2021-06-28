package ru.maxdexter.filmapp.di

import dagger.Module
import dagger.Provides
import ru.maxdexter.filmapp.data.remote_source.MovieService
import ru.maxdexter.filmapp.data.remote_source.api.MovieApi
import javax.inject.Singleton

@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideMovieApi(): MovieApi {
        return MovieService.api
    }
}