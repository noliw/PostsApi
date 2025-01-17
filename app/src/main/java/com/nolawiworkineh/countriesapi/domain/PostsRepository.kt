package com.nolawiworkineh.countriesapi.domain

import com.nolawiworkineh.countriesapi.data.PostsModel
import com.nolawiworkineh.countriesapi.data.network.util.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    suspend fun getPosts(): NetworkResponse<List<PostsModel>>
}