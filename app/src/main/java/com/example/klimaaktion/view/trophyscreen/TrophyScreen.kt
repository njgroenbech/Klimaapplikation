package com.example.klimaaktion.view.trophyscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

/**
 * Entry point for trofæskærmen.
 * Sender NavController videre til TrophyScreenContent, hvor indholdet vises.
 */
// Skrevet af Jacob
@Composable
fun TrophyScreen(navController: NavController) {
    TrophyScreenContent(navController)
}
