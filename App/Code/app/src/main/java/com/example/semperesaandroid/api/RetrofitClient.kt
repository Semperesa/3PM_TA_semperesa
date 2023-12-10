package com.example.semperesaandroid.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Retrofit client for making network requests
object RetrofitClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://semperesaandroid.free.beeceptor.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}