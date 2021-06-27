package ru.maxdexter.filmapp.data.remote_source.model

data class Movies(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)