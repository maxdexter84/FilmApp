package ru.maxdexter.filmapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxdexter.filmapp.databinding.ItemMovieBinding
import ru.maxdexter.filmapp.ui.model.MovieUI
import ru.maxdexter.filmapp.utils.setImage

class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: MovieUI) {
        binding.tvTitle.text = item.title
        binding.tvDescription.text = item.description
        binding.ivMovieImage.setImage(item.image)
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
            return MovieViewHolder(binding)
        }
    }
}