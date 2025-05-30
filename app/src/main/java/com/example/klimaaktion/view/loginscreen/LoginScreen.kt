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

/**
 * Entry point for loginskærmen.
 * Initialiserer LoginViewModel og placerer LoginScreenContent i en farvet baggrund.
 *
 * LoginViewModel håndterer brugerinput og logik, mens UI deles op i komponenter.
 */
// Skrever af Laurits
@Composable
fun LoginScreen(navController: NavController) {
    val vm: LoginViewModel = viewModel() // ViewModel til håndtering af loginstatus og input

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA)) // Lyseblå baggrund
    ) {
        // Videresender ViewModel og NavController til selve UI-indholdet
        LoginScreenContent(
            navController = navController,
            viewModel = vm
        )
    }
}
