package com.example.semperesaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Show button on the nav bar to go to the previous activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        this.title = "Contact"
    }
}