package com.example.myktorsampleapp.di

import com.example.myktorsampleapp.data.remote.network.PostsApiClient
import com.example.myktorsampleapp.data.remote.repository.NetworkPostsRepository
import com.example.myktorsampleapp.data.remote.repository.PostsRepository

class DefaultAppContainer : AppContainer {
    override val postsRepository: PostsRepository by lazy {
        NetworkPostsRepository(PostsApiClient.client)
    }
}