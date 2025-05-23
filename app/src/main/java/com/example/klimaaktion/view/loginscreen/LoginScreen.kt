package com.example.klimaaktion.view.loginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA))
    ) {
        LoginScreenContent()
    }
}


