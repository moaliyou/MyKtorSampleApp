package com.example.myktorsampleapp

import android.app.Application
import com.example.myktorsampleapp.di.AppContainer
import com.example.myktorsampleapp.di.DefaultAppContainer

class PostsApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}