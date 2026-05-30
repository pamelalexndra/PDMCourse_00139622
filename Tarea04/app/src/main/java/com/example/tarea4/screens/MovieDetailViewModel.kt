package com.example.tarea4.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tarea4.model.Movie
import com.example.tarea4.repositories.MovieRepository.MovieApiRepository
import com.example.tarea4.repositories.MovieRepository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {
    private val movieRepository: MovieRepository = MovieApiRepository()

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie = _movie.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    fun loadMovieById(id: Int) {
        viewModelScope.launch {
            _loading.value = true
            _movie.value = movieRepository.getMovieById(id)
            _loading.value = false
        }
    }
}