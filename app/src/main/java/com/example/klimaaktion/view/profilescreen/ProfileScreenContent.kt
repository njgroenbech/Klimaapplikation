package com.example.klimaaktion.view.profilescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
// UI rettet til af Jacob
@Composable
fun ProfileScreenContent(
    backgroundColor: Color,
    onSettingsClick: () -> Unit,
    onTrophyClick: () -> Unit
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
        ProfileTopBar(
            onSettingsClick = onSettingsClick,
            onTrophyClick = onTrophyClick
        )
        Spacer(modifier = Modifier.height(30.dp))
        ProfileMainContent()
        Spacer(modifier = Modifier.height(16.dp))
        ProfileProgressBar(points = 35, maxPoints = 250)
        Spacer(modifier = Modifier.height(24.dp))
        ProfileGroupGrid()
        Spacer(modifier = Modifier.height(24.dp))

    }
}