package com.example.tarea4.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea4.model.Movie
import com.example.tarea4.repositories.MovieRepository.MovieApiRepository
import com.example.tarea4.repositories.MovieRepository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel : ViewModel() {
    private val movieRepository: MovieRepository = MovieApiRepository()
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _loading.value = true
            _movies.value = movieRepository.getMovies()
            _loading.value = false
        }
    }
}