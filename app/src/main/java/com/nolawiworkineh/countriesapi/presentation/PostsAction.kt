package com.nolawiworkineh.countriesapi.presentation

sealed interface PostsAction{
    data object OnGetPostsClick: PostsAction
}