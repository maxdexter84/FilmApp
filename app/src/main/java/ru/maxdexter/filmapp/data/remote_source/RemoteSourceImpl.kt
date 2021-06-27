package ru.maxdexter.filmapp.data.remote_source

import ru.maxdexter.filmapp.data.remote_source.api.MovieApi
import ru.maxdexter.filmapp.data.remote_source.model.Movies
import ru.maxdexter.filmapp.domain.interfaces.RemoteSource
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(private val api: MovieApi) : RemoteSource<Movies> {

    override suspend fun getData(): Movies {
        return api.getAllMovies()
    }
}