package com.example.semperesaandroid.api

import com.example.semperesaandroid.character.Character
import retrofit2.http.GET

// Retrofit interface for fetching heroes data
interface ApiService {
    @GET("/characters.json")
    suspend fun getCharacters(): List<Character>
}