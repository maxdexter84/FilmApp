package ru.maxdexter.filmapp.data.remote_source.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.maxdexter.filmapp.data.remote_source.model.Movies
const val API_KEY: String = "9Pb9DdbWqKU6cREKmYeR7z4HpGdf4Z4Y"
interface MovieApi {
    @GET("svc/movies/v2/reviews/all.json")
    suspend fun getAllMovies(@Query("offset") offset: Int = 0, @Query("api-key") key: String = API_KEY): Movies
}