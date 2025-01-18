package com.nolawiworkineh.countriesapi.presentation

import com.nolawiworkineh.countriesapi.data.network.PostsModel

data class PostsState(
    val posts: List<PostsModel> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)