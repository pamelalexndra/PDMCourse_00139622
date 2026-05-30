package com.example.tarea4.repositories.MovieRepository

import com.example.tarea4.api.KtorClient
import com.example.tarea4.Movies.GetMoviesResponseDto
import com.example.tarea4.Movies.MovieDto
import com.example.tarea4.Movies.toModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import com.example.tarea4.model.Movie

class MovieApiRepository : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        val response: GetMoviesResponseDto = KtorClient.client.get("movie/popular") {
            parameter("language", "es-ES")
            parameter("page", 1)
        }.body()

        return response.results.map { movieDto -> movieDto.toModel() }
    }

    override suspend fun getMovieById(id: Int): com.example.tarea4.model.Movie? {
        val response: MovieDto = KtorClient.client.get("movie/$id") {
            parameter("language", "es-ES")
        }.body()

        return response.toModel()
    }
}