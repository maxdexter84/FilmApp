package ru.maxdexter.filmapp

import android.app.Application
import ru.maxdexter.filmapp.di.AppComponent
import ru.maxdexter.filmapp.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}