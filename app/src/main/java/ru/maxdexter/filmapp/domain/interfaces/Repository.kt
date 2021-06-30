package ru.maxdexter.filmapp.domain.interfaces

import kotlinx.coroutines.flow.Flow
import ru.maxdexter.filmapp.domain.common.LoadState

interface Repository {
    suspend fun loadMovies(): Flow<LoadState<*>>
}