package com.example.myktorsampleapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myktorsampleapp.PostsApplication
import com.example.myktorsampleapp.data.remote.repository.PostsRepository
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PostsViewModel(
    private val postsRepository: PostsRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow<PostsUiState>(PostsUiState.Loading)
    val uiState: StateFlow<PostsUiState> = _uiState.asStateFlow()

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {
            _uiState.value = PostsUiState.Loading
            _uiState.value = try {
                PostsUiState.Success(postsRepository.getPosts())
            } catch (e: ServerResponseException) {
                PostsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as PostsApplication)
                val postsRepository = application.container.postsRepository
                PostsViewModel(postsRepository)
            }
        }
    }

}