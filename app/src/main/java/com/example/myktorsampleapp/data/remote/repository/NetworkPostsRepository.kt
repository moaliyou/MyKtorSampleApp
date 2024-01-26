package com.example.myktorsampleapp.data.remote.repository

import com.example.myktorsampleapp.data.remote.dto.PostResponse
import com.example.myktorsampleapp.data.remote.network.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.get

class NetworkPostsRepository(
    private val client: HttpClient
) : PostsRepository{
    override suspend fun getPosts(): List<PostResponse> {
        return try {
            client.get(HttpRoutes.POSTS).body()
        } catch (e: ClientRequestException) {
            println(e.message)
            emptyList()
        }
    }
}