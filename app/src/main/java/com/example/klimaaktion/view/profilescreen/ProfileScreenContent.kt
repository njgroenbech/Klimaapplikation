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
import com.example.klimaaktion.view.profilescreen.components.ProfileTopBar

// Kode skrevet af Felix
@Composable
fun ProfileScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFF8ECBEA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileTopBar()
        Spacer(modifier = Modifier.height(12.dp))
        ProfileMainContent()
        Spacer(modifier = Modifier.height(12.dp))
        ProfileGroupGrid()
    }
}

