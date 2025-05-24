package com.example.klimaaktion.view.taskScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.klimaaktion.view.sharedcomponents.BottomNavBar
import com.example.klimaaktion.viewmodel.MainViewModel
import com.example.klimaaktion.view.taskscreen.components.TaskCard


// Nedenstående kode er lavet af Elias

@Composable
fun TaskScreen(viewModel: MainViewModel = viewModel(), navController: NavController) {

    Scaffold(
        bottomBar = {
            BottomNavBar(navController, currentRoute = "check")
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFACD8F1))
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Opgaver",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                )

                LazyColumn {
                    items(viewModel.taskList, key = { it.id }) { taskId ->
                        TaskCard(
                            task = taskId,
                            onTaskDone = { viewModel.removeTask(taskId) }
                        )
                    }
                }

            }
        }
    }

}
