package com.example.klimaaktion.view.taskscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.view.taskscreen.components.TaskCard
import com.example.klimaaktion.viewmodel.MainViewModel

// Nedenstående kode er lavet af Elias
// UI rettet til af Jacob

@Composable
fun TaskScreen(viewModel: MainViewModel,
               navController: NavController,
               modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFACD8F1))
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 75.dp)
                .fillMaxSize()
        ) {

            // Row med overskrift og knap
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Opgaver",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                )
                Button(
                    onClick = {
                        viewModel.fetchTasksFromOpenAI()
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6CD59A)),
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    modifier = Modifier
                        .width(160.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "AI-opgaver",
                        color = Color(0xFF343434),
                        fontSize = 18.sp
                    )
                }
            }

            LazyColumn {
                items(viewModel.taskList, key = { it.id }) { task ->
                    TaskCard(
                        task = task,
                        onTaskDone = {
                            // 1) Fjern opgaven
                            viewModel.removeTask(task)
                            // 2) Giv de rigtige point
                            viewModel.onTaskCompleted(task.points)
                        }
                    )
                }
            }
        }
    }
}
