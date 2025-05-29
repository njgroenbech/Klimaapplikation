package com.example.klimaaktion.view.progressscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.viewmodel.MainViewModel

// Nicholas
// UI rettet til af Jacob
// UI lavet af Nicholas.
// Funktionalitet tilføjet af Elias

@Composable
fun ProgressScreenContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val totalTasks = viewModel.totalTasks
    var totalPoints = viewModel.totalPointsInTasks
    val earnedPoints by viewModel.earnedPoints
    val completed by viewModel.completedTasks

    var percentage = if (totalPoints > 0) {
        earnedPoints.toFloat() / totalPoints
    } else 0f

    val level = 1 + (completed / 10)

    if (earnedPoints == totalPoints) {
        percentage = 0f
        totalPoints += 125
        viewModel.resetEarnedPoints()
    }

    Column(
        modifier = Modifier
            .background(Color(0xFFACD8F1))
            .then(modifier)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Klassens Klima Fremskridt",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF202020),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        CircularProgressBar(percentage = percentage)

        Spacer(modifier = Modifier.height(42.dp))

        Text(
            text = "I er på level $level",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "$earnedPoints point / $totalPoints point",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF224B43)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Top 3 - Leaderboard",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(10.dp))

        viewModel.leaderboard.collectAsState().value.forEach { entry ->
            LeaderboardCard(
                rank = entry.rank,
                name = entry.name,
                points = entry.points
            )
        }
    }
}