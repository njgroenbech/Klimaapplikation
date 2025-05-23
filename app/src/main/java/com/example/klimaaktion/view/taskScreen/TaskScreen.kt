package com.example.klimaaktion.view.taskScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.klimaaktion.model.Task
import com.example.klimaaktion.viewmodel.MainViewModel


// Nedenstående kode er lavet af Elias

@Composable
fun TaskScreen(viewModel: MainViewModel = viewModel()) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFACD8F1))
            .statusBarsPadding()
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
                modifier = Modifier.padding(vertical = 16.dp)
            )

            LazyColumn {
                items(viewModel.taskList, key = { it.id }) { task ->
                    TaskCard(task = task, onDone = { viewModel.removeTask(task) })
                }
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    onDone: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(task.backgroundColor, shape = RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = task.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${task.points} Point",
                fontSize = 14.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (!isExpanded) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = { isExpanded = true }) {
                        Text("Start")
                    }
                    Row {
                        IconButton(onClick = {}) {
                           // Icon(Icons.Default.Help, contentDescription = "Hjælp")
                        }
                        IconButton(onClick = {}) {
                            // Icon(Icons.Default.MenuBook, contentDescription = "Læs mere")
                        }
                    }
                }
            } else {
                Text(
                    text = task.fact,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Button(
                    onClick = onDone,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005F3D))
                ) {
                    Text("Jeg har gjort det! - ${task.points} point", color = Color.White)
                }
            }
        }
    }
}

