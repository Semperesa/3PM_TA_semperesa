package com.example.semperesaandroid.character

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.semperesaandroid.api.RetrofitClient
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters;

    fun loadCharacters() {
        viewModelScope.launch {
            try {
                val charactersList = RetrofitClient.apiService.getCharacters()
                _characters.value = charactersList
            } catch(e: Exception) {
                Log.d("Error", "Error loading characters: ${e.message}")
            }
        }
    }
}