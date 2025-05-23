package com.example.klimaaktion.view.profilescreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.klimaaktion.view.sharedcomponents.BottomNavBar

// Kode skrevet af Felix
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavBar(navController, currentRoute = "profile")
        }
    ) { innerPadding ->
        ProfileScreenContent(modifier = Modifier.padding(innerPadding))
    }
}
