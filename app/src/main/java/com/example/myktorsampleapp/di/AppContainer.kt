package com.example.myktorsampleapp.di

import com.example.myktorsampleapp.data.remote.repository.PostsRepository

interface AppContainer {
    val postsRepository: PostsRepository
}