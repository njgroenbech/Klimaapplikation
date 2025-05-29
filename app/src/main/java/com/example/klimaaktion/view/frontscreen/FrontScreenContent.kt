package com.example.klimaaktion.view.frontscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.klimaaktion.view.frontscreen.components.FrontScreenButtons
import com.example.klimaaktion.view.frontscreen.components.FrontScreenImages

/**
 * Indholdet for appens forside efter introforløbet.
 * Består af to sektioner:
 * – FrontScreenImages: Logo og illustrationer
 * – FrontScreenButtons: Navigation videre i appen
 */
// Skrevet af Felix
@Composable
fun FrontScreenContent(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA)), // Konsistent blå baggrund
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 40.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Øverste sektion med logo og billede
            FrontScreenImages()

            Spacer(modifier = Modifier.height(40.dp))

            // Nederste sektion med knapper
            FrontScreenButtons(navController = navController)

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
