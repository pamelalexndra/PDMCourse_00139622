package com.example.tarea4.repositories.MovieRepository

import com.example.tarea4.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
    suspend fun getMovieById(id: Int): Movie?
}