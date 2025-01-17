package com.nolawiworkineh.countriesapi.data.network

import com.nolawiworkineh.countriesapi.data.PostsModel
import retrofit2.http.GET

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostsModel>
}