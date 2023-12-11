package com.example.semperesaandroid

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

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
        val characterImage = intent.getStringExtra("character_image")

        // Set the character name as Activity title
        this.title = characterName

        // Set the character real name to its TextView
        findViewById<TextView>(R.id.characterRealName).text = characterRealName

        // Set the character role to its TextView
        findViewById<TextView>(R.id.characterRole).text = characterRole

        // Set the character description to its TextView
        findViewById<TextView>(R.id.characterDescription).text = characterDescription

        val imageView = findViewById<ImageView>(R.id.characterImage)

        Glide.with(this)
            .load(characterImage)
            .error(R.drawable.batlogo) // Load same image as above in case of error
            .into(imageView) // If everything is ok load image into the ImageView

    }
}