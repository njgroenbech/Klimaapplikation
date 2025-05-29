package com.example.klimaaktion.view.progressscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.klimaaktion.view.progressscreen.components.ProgressScreenContent
import com.example.klimaaktion.viewmodel.MainViewModel

// Skrevet af Jacob
@Composable
fun ProgressScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    ProgressScreenContent(
        navController = navController,
        modifier = modifier,
        viewModel = viewModel
    )
}