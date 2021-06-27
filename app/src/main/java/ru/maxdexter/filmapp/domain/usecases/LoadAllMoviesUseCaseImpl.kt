package ru.maxdexter.filmapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.maxdexter.filmapp.domain.common.LoadState
import ru.maxdexter.filmapp.domain.interfaces.Repository
import javax.inject.Inject

class LoadAllMoviesUseCaseImpl @Inject constructor(private val repository: Repository) :
    LoadAllMoviesUseCase{
    override suspend fun getAllMovies(): Flow<LoadState<*>> {
        return repository.loadMovies()
    }
}