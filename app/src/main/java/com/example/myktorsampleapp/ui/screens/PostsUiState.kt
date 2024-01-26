package com.example.myktorsampleapp.ui.screens

import com.example.myktorsampleapp.data.remote.dto.PostResponse

sealed interface PostsUiState {
    data class Success(val postResponse: List<PostResponse>) : PostsUiState
    data object Error : PostsUiState
    data object Loading : PostsUiState
}