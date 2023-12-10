package com.example.semperesaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MyMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_main)

        val loginBtn = findViewById<Button>(R.id.loginBtn).setOnClickListener {

            val username = findViewById<TextInputLayout>(R.id.loginUsername).editText?.text.toString();
            val password = findViewById<TextInputLayout>(R.id.loginPassword).editText?.text.toString();

            val usr : String = "Admin";
            val pwd : String = "a123456*";

            if(username == usr && password == pwd) {
                Toast.makeText(this, "Welcome :)", Toast.LENGTH_SHORT).show();
                val intent = Intent(this, CharacterSelectionActivity::class.java);
                this.startActivity(intent);
            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }

}