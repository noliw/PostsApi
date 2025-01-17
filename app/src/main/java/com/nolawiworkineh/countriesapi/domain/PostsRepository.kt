package com.nolawiworkineh.countriesapi.domain

import com.nolawiworkineh.countriesapi.data.network.PostsModel
import com.nolawiworkineh.countriesapi.data.network.util.NetworkResponse

interface PostsRepository {
    suspend fun getPosts(): NetworkResponse<List<PostsModel>>
}