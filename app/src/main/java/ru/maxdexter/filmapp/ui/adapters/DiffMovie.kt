package ru.maxdexter.filmapp.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import ru.maxdexter.filmapp.ui.model.MovieUI

class DiffMovie : DiffUtil.ItemCallback<MovieUI>() {
    override fun areItemsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MovieUI, newItem: MovieUI): Boolean {
        return oldItem.description == newItem.description
    }
}