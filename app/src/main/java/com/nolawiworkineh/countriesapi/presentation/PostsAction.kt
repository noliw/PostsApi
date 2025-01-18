package com.nolawiworkineh.countriesapi.presentation

sealed interface PostsAction{
    data object OnShowPostsClick: PostsAction
}