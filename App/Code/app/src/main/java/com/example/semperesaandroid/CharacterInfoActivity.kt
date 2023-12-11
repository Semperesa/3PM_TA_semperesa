package com.example.semperesaandroid

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class CharacterInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_info)

        // Show button on the nav bar to go to the previous activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        /*val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash")
        }
        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ))*/

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