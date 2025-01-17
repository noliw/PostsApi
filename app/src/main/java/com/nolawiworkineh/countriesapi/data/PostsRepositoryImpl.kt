package com.nolawiworkineh.countriesapi.data

import com.nolawiworkineh.countriesapi.data.network.PostsApiService
import com.nolawiworkineh.countriesapi.data.network.PostsModel
import com.nolawiworkineh.countriesapi.data.network.util.NetworkResponse
import com.nolawiworkineh.countriesapi.data.network.util.safeApiCall
import com.nolawiworkineh.countriesapi.domain.PostsRepository
import javax.inject.Inject


class PostsRepositoryImpl @Inject constructor(
    private val postsApiService: PostsApiService
): PostsRepository {
    override suspend fun getPosts(): NetworkResponse<List<PostsModel>> {
        return safeApiCall {
            postsApiService.getPosts()
        }
    }
}