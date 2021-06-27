package ru.maxdexter.filmapp.di.subcomponent

import dagger.Subcomponent
import ru.maxdexter.filmapp.ui.fragments.FilmsListFragment

@Subcomponent(modules = [FilmsListModule::class])
interface FilmsListSubComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FilmsListSubComponent
    }

    fun inject(fragment: FilmsListFragment)
}