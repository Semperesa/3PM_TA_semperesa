package com.example.semperesaandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.semperesaandroid.interfaces.LoginForm
import com.example.semperesaandroid.ui.theme.SemperesaTheme

class MyMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemperesaTheme {
                LoginForm()
            }
        }
    }

}