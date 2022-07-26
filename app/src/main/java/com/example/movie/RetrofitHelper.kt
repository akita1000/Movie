package com.example.movie

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getMovieApi(): MovieApi {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var movieApi: MovieApi = retrofit.create(MovieApi::class.java)
        return movieApi
    }
}