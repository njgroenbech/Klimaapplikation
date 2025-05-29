package com.example.klimaaktion.view.introscreen2

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// Skrevet af Elias
// UI rettet af Jacob

/**
 * Entry point for introduktionsskærm 2.
 * Kalder IntroScreen2Content og sender navController videre.
 * Følger projektets skærmstruktur: én skærmfil + separat indholdskomponent.
 */
@Composable
fun IntroScreen2(navController: NavController) {
    IntroScreen2Content(navController = navController)
}
