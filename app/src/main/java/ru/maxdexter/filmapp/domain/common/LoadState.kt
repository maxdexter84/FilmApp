package ru.maxdexter.filmapp.domain.common

sealed class LoadState<out R> {
    data class Success<out T>(val data: T) : LoadState<T>()
    data class Error(val exception: Exception) : LoadState<Nothing>()
    object Loading : LoadState<Nothing>()
}