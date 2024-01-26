package com.example.myktorsampleapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myktorsampleapp.ui.screens.PostsScreen
import com.example.myktorsampleapp.ui.screens.PostsViewModel

@Composable
fun PostsApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val postsViewModel: PostsViewModel =
            viewModel(factory = PostsViewModel.Factory)
        val postsUiState = postsViewModel.uiState.collectAsState()
        PostsScreen(
            postsUiState = postsUiState.value,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}