package ru.maxdexter.filmapp.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.maxdexter.filmapp.ui.model.MovieUI

class MovieAdapter : ListAdapter<MovieUI, MovieViewHolder>(DiffMovie()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}