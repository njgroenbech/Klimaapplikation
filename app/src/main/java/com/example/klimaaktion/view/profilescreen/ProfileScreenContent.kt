package com.example.klimaaktion.view.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.view.profilescreen.components.ProfileGroupGrid
import com.example.klimaaktion.view.profilescreen.components.ProfileMainContent
import com.example.klimaaktion.view.profilescreen.components.ProfileProgressBar
import com.example.klimaaktion.view.profilescreen.components.ProfileTopBar

// Kode skrevet af Felix
// UI justeret og tilpasset af Jacob

/**
 * Viser det samlede indhold på profilsiden.
 * Består af topbar, brugerinfo, fremgangsbar og grupper.
 * Modtager to callbacks: en til at åbne drawer (indstillinger)
 * og en til at navigere til trofæskærmen.
 */
@Composable
fun ProfileScreenContent(
    backgroundColor: Color,
    onSettingsClick: () -> Unit, // Kaldes når brugeren klikker på indstillingsikonet (åbner drawer)
    onTrophyClick: () -> Unit    // Kaldes når brugeren klikker på trofæikonet (navigerer til ny skærm)
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Topbar-komponent med ikoner til drawer, navigation og titel
        ProfileTopBar(
            onSettingsClick = onSettingsClick,
            onTrophyClick = onTrophyClick
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Brugerens navn, avatar og evt. statistik vises her
        ProfileMainContent()

        Spacer(modifier = Modifier.height(16.dp))

        // Fremgangsbar viser brugerens point
        ProfileProgressBar(points = 35, maxPoints = 250)

        Spacer(modifier = Modifier.height(24.dp))

        // Grid-layout med grupper brugeren deltager i
        ProfileGroupGrid()

        Spacer(modifier = Modifier.height(24.dp))
    }
}
