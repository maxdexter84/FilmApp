package ru.maxdexter.filmapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.maxdexter.filmapp.domain.common.LoadState

interface LoadAllMoviesUseCase {
  suspend fun getAllMovies(): Flow<LoadState<*>>
}