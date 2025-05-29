package com.example.klimaaktion.view.feedscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/**
 * Entry point for Feed-skærmen.
 * Videresender NavController og eventuel modifier til FeedScreenContent.
 * Følger samme skærmstruktur som resten af appen (skærm + content).
 */
// Skrevet Jacob
@Composable
fun FeedScreen(navController: NavController, modifier: Modifier = Modifier) {
    FeedScreenContent(navController = navController)
}
