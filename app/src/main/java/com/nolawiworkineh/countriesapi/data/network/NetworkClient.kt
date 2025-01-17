package com.nolawiworkineh.countriesapi.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private const val BASE_URL =  "https://jsonplaceholder.typicode.com/"

    fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}