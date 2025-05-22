package com.example.klimaaktion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.klimaaktion.ui.theme.KlimaAktionTheme
import com.example.klimaaktion.view.IntroScreen1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KlimaAktionTheme {
                IntroScreen1()
            }
        }
    }
}