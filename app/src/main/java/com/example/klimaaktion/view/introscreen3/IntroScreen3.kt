package com.example.klimaaktion.view.introscreen3

import IntroScreen3Content
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// Skrevet af Jacob

/**
 * Entry point for IntroScreen3.
 * Videresender navController til det visuelle indhold i IntroScreen3Content.
 * Følger samme struktur som de øvrige skærme i projektet (skærm + content + components).
 */
@Composable
fun IntroScreen3(navController: NavController) {
    IntroScreen3Content(navController = navController)
}
