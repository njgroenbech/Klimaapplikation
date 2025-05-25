package com.example.klimaaktion.view.feedscreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun FeedScreen(navController: NavController, modifier: Modifier = Modifier) {
    FeedScreenContent(navController = navController)
}