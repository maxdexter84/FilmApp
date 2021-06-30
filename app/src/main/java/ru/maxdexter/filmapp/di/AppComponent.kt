package ru.maxdexter.filmapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.maxdexter.filmapp.di.subcomponent.FilmsListSubComponent
import ru.maxdexter.filmapp.di.subcomponent.SubComponentsModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        MainModule::class,
        SubComponentsModule::class,
        ViewModelBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun filmsFragment(): FilmsListSubComponent.Factory
}