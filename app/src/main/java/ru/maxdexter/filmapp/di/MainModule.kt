package ru.maxdexter.filmapp.di

import dagger.Binds
import dagger.Module
import ru.maxdexter.filmapp.data.remote_source.RemoteSourceImpl
import ru.maxdexter.filmapp.data.remote_source.model.Movies
import ru.maxdexter.filmapp.data.repository.RepositoryImpl
import ru.maxdexter.filmapp.domain.interfaces.RemoteSource
import ru.maxdexter.filmapp.domain.interfaces.Repository

@Module
abstract class MainModule {

    @Binds
    abstract fun bindsRemoteSource(remote: RemoteSourceImpl): RemoteSource<Movies>

    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository


}