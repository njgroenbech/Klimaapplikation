package com.example.klimaaktion.view.taskscreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.klimaaktion.view.taskscreen.components.TaskScreenContent
import com.example.klimaaktion.viewmodel.MainViewModel

// Nedenstående kode er lavet af Elias
// En lille smule er skrevet af Felix, se kommentare i koden.
// hope this shit works
// UI rettet til af Jacob

@Composable
fun TaskScreen(
    viewModel: MainViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    TaskScreenContent(
        viewModel = viewModel,
        navController = navController,
        modifier = modifier
    )
}