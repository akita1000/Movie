package com.example.movie

import retrofit2.http.GET

interface MovieApi {
    @GET("movielist.json")
    suspend fun getMovie(): List<Movie>
}