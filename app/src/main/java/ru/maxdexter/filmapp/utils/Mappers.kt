package ru.maxdexter.filmapp.utils

import ru.maxdexter.filmapp.data.remote_source.model.Movies
import ru.maxdexter.filmapp.data.remote_source.model.Result
import ru.maxdexter.filmapp.ui.model.MovieUI

class Mappers {


    companion object {
        fun mapResultListToMovieUiList(movies: Movies): List<MovieUI> {
           return movies.results.map { mapResultToMovieUi(it) }
        }

        private fun mapResultToMovieUi(result: Result): MovieUI {
            return MovieUI(
                result.display_title,
                result.summary_short, result.multimedia.src
            )
        }
    }
}