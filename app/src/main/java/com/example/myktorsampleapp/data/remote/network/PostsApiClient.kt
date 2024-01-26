package com.example.myktorsampleapp.data.remote.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object PostsApiClient {
    val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }
}