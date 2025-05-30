package com.example.klimaaktion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.klimaaktion.navigation.AppNavHost
import com.example.klimaaktion.ui.theme.KlimaAktionTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KlimaAktionTheme {
                AppNavHost()
            }
        }
    }
}