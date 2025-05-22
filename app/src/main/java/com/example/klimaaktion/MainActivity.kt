package com.example.klimaaktion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.klimaaktion.navigation.AppNavHost
import com.example.klimaaktion.ui.theme.KlimaAktionTheme
import com.example.klimaaktion.view.introscreen2.IntroScreen2


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