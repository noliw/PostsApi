package com.nolawiworkineh.countriesapi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nolawiworkineh.countriesapi.data.network.util.NetworkResponse
import com.nolawiworkineh.countriesapi.domain.PostsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val repository: PostsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PostsState())
    var state: StateFlow<PostsState> = _state.onStart {

    }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PostsState())


    fun onAction(action: PostsAction) {
        when (action) {
            is PostsAction.OnGetPostsClick -> fetchPosts()
        }
    }

    private fun fetchPosts(){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            when (val result = repository.getPosts()) {
                is NetworkResponse.Success -> {
                    _state.value = _state.value.copy(
                        posts = result.data,
                        isLoading = false
                    )
                }
                is NetworkResponse.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        // Assuming we add errorMessage in PostsState later
                    )
                }
                else -> {
                    _state.value = _state.value.copy(isLoading = false)
                }
            }
        }
    }
}


