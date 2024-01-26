package com.example.myktorsampleapp.data.remote.repository

import com.example.myktorsampleapp.data.remote.dto.PostResponse

interface PostsRepository {
    suspend fun getPosts() : List<PostResponse>
}