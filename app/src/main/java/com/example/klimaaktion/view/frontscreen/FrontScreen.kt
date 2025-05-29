package com.example.klimaaktion.view.frontscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

// Skrevet af Felix

/**
 * Entry point for forsiden efter intro.
 * Videresender NavController til FrontScreenContent, hvor UI og navigation håndteres.
 * Strukturen følger projektets mønster: skærmfil + separat content-fil.
 */
@Composable
fun FrontScreen(navController: NavController) {
   FrontScreenContent(navController = navController)
}
