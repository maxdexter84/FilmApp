package ru.maxdexter.filmapp.data.repository

import kotlinx.coroutines.flow.flow
import ru.maxdexter.filmapp.data.remote_source.model.Movies
import ru.maxdexter.filmapp.domain.common.LoadState
import ru.maxdexter.filmapp.domain.interfaces.RemoteSource
import ru.maxdexter.filmapp.domain.interfaces.Repository
import ru.maxdexter.filmapp.utils.Mappers
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remote: RemoteSource<Movies>) :
    Repository {
    override suspend fun loadMovies() = flow {
        remote.runCatching {
            emit(LoadState.Loading)
            getData()
        }.onSuccess {
            emit(LoadState.Success(Mappers.mapResultListToMovieUiList(it)))
        }.onFailure {
            emit(LoadState.Error(it))
        }
    }
}