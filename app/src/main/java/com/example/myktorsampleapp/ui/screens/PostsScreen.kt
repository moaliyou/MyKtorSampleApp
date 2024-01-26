package com.example.myktorsampleapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myktorsampleapp.data.remote.dto.PostResponse
import com.example.myktorsampleapp.ui.theme.MyKtorSampleAppTheme

@Composable
fun PostsScreen(
    postsUiState: PostsUiState,
    modifier: Modifier
) {
    when(postsUiState) {
        is PostsUiState.Loading -> {}
        is PostsUiState.Error -> {}
        is PostsUiState.Success -> {
            PostsDetailScreen(
                modifier = modifier,
                posts = postsUiState.postResponse
            )
        }
    }
}

@Composable
private fun PostsDetailScreen(
    modifier: Modifier,
    posts: List<PostResponse>
) {
    LazyColumn {
        items(posts) { post ->
            Column(modifier = modifier) {
                Text(
                    text = post.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = post.body,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PostsDetailScreenPreview() {
    MyKtorSampleAppTheme {
        val mockData = List(10) {
            PostResponse(
                title = "Lorem Ipsum - $it",
                id = it,
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad" +
                        " minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip" +
                        " ex ea commodo consequat.",
                userId = it.plus(2)
            )
        }
        PostsDetailScreen(
            posts = mockData,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}