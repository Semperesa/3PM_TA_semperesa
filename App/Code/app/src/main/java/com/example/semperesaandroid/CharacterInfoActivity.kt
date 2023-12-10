package com.example.semperesaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CharacterInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_info)

        val characterName = intent.getStringExtra("character_name")
        val characterRealName = intent.getStringExtra("character_real_name")
        val characterRole = intent.getStringExtra("character_role")
        val characterDescription = intent.getStringExtra("character_description")

        // Set the character name as Activity title
        this.title = characterName

        // Set the character real name to its TextView
        findViewById<TextView>(R.id.characterRealName).text = characterRealName

        // Set the character role to its TextView
        findViewById<TextView>(R.id.characterRole).text = characterRole

        // Set the character description to its TextView
        findViewById<TextView>(R.id.characterDescription).text = characterDescription

    }
}