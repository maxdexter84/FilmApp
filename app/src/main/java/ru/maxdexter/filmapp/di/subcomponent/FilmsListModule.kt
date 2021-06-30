package ru.maxdexter.filmapp.di.subcomponent

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.maxdexter.filmapp.di.ViewModelKey
import ru.maxdexter.filmapp.domain.usecases.LoadAllMoviesUseCase
import ru.maxdexter.filmapp.domain.usecases.LoadAllMoviesUseCaseImpl
import ru.maxdexter.filmapp.ui.fragments.FilmsListViewModel

@Module
abstract class FilmsListModule {

    @Binds
    @IntoMap
    @ViewModelKey(FilmsListViewModel::class)
    abstract fun bindsFilmsListViewModel(viewModel: FilmsListViewModel): ViewModel

    @Binds
    abstract fun bindsUseCase(useCase: LoadAllMoviesUseCaseImpl): LoadAllMoviesUseCase
}