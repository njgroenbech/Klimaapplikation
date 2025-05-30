package com.example.klimaaktion.view.loginscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.klimaaktion.viewmodel.LoginViewModel


// Skrever af Laurits
@Composable
fun LoginScreen(navController: NavController) {
    val vm: LoginViewModel = viewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA))
    ) {

        LoginScreenContent(
            navController = navController,
            viewModel = vm
        )
    }
}
