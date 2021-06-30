package ru.maxdexter.filmapp.domain.interfaces

import kotlinx.coroutines.flow.Flow

interface RemoteSource<out T> {
    suspend fun getData(): T
}