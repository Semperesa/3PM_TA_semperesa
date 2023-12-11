package com.example.semperesaandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Show button on the nav bar to go to the previous activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        this.title = "Contact Form"

        val nameEditText = findViewById<EditText>(R.id.contactName);
        val emailEditText = findViewById<EditText>(R.id.contactEmail);
        val subjectEditText = findViewById<EditText>(R.id.contactSubject);
        val messageEditText = findViewById<EditText>(R.id.contactMessage);
        val submit = findViewById<Button>(R.id.submitButton);

        submit.setOnClickListener {
            val name: String = nameEditText.text.toString();
            val email: String = emailEditText.text.toString();
            val subject: String = subjectEditText.text.toString();
            val message: String = messageEditText.text.toString();

            if (name.isEmpty()) { nameEditText.error = "Enter Your Name"; }
            if (email.isEmpty()) { emailEditText.error = "Enter Your Email"; }
            if (subject.isEmpty()) { subjectEditText.error = "Enter Your Subject"; }
            if (message.isEmpty()) { messageEditText.error = "Enter Your Message"; }

            if (name.isNotEmpty() && email.isNotEmpty() && subject.isNotEmpty() && message.isNotEmpty()) {
                val sendEmail: Intent = Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                sendEmail.type = "plain/text";
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, "semperesa@esat-alumni.com");
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT, "Name: $name\nEmail: $email\nMessage:\n$message");

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(sendEmail, "Send mail..."));
            }
            else {
                Toast.makeText(this, "All fields must be filled in", Toast.LENGTH_SHORT).show()
            }

        }
    }
}