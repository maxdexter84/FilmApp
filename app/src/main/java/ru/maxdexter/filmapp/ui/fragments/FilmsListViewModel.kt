package ru.maxdexter.filmapp.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.maxdexter.filmapp.domain.common.LoadState
import ru.maxdexter.filmapp.domain.usecases.LoadAllMoviesUseCase
import ru.maxdexter.filmapp.ui.model.MovieUI
import javax.inject.Inject

class FilmsListViewModel @Inject constructor(private val useCase: LoadAllMoviesUseCase) : ViewModel() {


    private val _data = MutableLiveData<LoadState<*>?>()
    val data: LiveData<LoadState<*>?>
    get() = _data



    init {
        _data.value = null
        loadData()
    }

     fun loadData(){
        viewModelScope.launch {
            useCase.getAllMovies().collect {
                _data.value = it
            }
        }
    }

}