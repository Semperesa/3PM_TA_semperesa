package com.example.semperesaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.semperesaandroid.character.Character
import com.example.semperesaandroid.character.CharacterSelectionListener

class CharacterSelectionActivity : AppCompatActivity(), CharacterSelectionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_selection)
    }

    override fun onCharacterSelected(character: Character) {
        // Save Name - SharedPreferences
        val sharedPreferences = getSharedPreferences("MyCharacterSharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("character_key", character.name);
        editor.apply()

        // Toast
        Toast.makeText(this, character.name, Toast.LENGTH_LONG).show()

        //Intent
        val intent = Intent(this, CharacterInfoActivity::class.java).apply {
            putExtra("character_name", character.name)
            putExtra("character_real_name", character.realName)
            putExtra("character_role", character.role)
            putExtra("character_description", character.description)
            putExtra("character_image", character.imageURL)
        }
        this.startActivity(intent)
    }
}