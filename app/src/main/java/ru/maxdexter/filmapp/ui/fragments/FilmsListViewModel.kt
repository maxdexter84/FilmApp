package ru.maxdexter.filmapp.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.maxdexter.filmapp.domain.common.LoadState
import ru.maxdexter.filmapp.domain.usecases.LoadAllMoviesUseCase
import ru.maxdexter.filmapp.ui.model.MovieUI
import javax.inject.Inject

class FilmsListViewModel @Inject constructor(private val useCase: LoadAllMoviesUseCase) : ViewModel() {


    private val _data = MutableStateFlow(emptyList<MovieUI>())
    val data = _data.asStateFlow()

    private val _error = MutableStateFlow("")
    val error = _data.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        loadData()
    }

    private fun loadData(){
        viewModelScope.launch {
            useCase.getAllMovies().onEach {
                when(it){
                    is LoadState.Error -> {
                        _isLoading.value = false
                        _error.value = "Ошибка рагрузки данных"
                    }
                    is LoadState.Success -> {
                        _isLoading.value = false
                        _data.value = it.data as List<MovieUI>
                    }
                    LoadState.Loading -> _isLoading.value = true
                }
            }
        }
    }

}