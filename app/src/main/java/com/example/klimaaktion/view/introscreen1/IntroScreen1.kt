package com.example.klimaaktion.view.introscreen1

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.klimaaktion.view.introscreen1.components.IntroScreen1Content

// Skrevet af Jacob

/**
 * Entry point for introduktionsskærm 1.
 * Initialiserer skærmen og sender NavController videre til indholdet.
 * Følger samme struktur som de øvrige intro-skærme i appen.
 */
@Composable
fun IntroScreen1(navController: NavController) {
    IntroScreen1Content(navController = navController)
}
