package com.example.klimaaktion.view.loginscreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.view.loginscreen.components.LoginButton
import com.example.klimaaktion.view.loginscreen.components.LoginForm
import com.example.klimaaktion.view.loginscreen.components.LogoHeader


@Composable
fun LoginScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        LogoHeader()
        Spacer(modifier = Modifier.height(70.dp))
        LoginForm()
        Spacer(modifier = Modifier.height(100.dp))
        LoginButton()
    }
}
