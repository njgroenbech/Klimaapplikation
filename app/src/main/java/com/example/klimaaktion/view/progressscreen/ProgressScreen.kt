package com.example.klimaaktion.view.progressscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.view.progressscreen.components.CircularProgressBar
import com.example.klimaaktion.view.progressscreen.components.LeaderboardCard
import com.example.klimaaktion.viewmodel.MainViewModel

// UI lavet af Nicholas.
// Funktionalitet tilføjet af Elias
@Composable
fun ProgressScreen(navController: NavController,
                   modifier: Modifier = Modifier,
                   viewModel: MainViewModel
) {
    val totalTasks    = viewModel.totalTasks // bruges muligvis til firebase.

    var totalPoints   = viewModel.totalPointsInTasks

    val earnedPoints by viewModel.earnedPoints

    val completed   by viewModel.completedTasks // Bruges også til firebase, når vi lige har fået fikset levelintrval

    var percentage = if (totalPoints > 0) {
        earnedPoints.toFloat() / totalPoints
    } else 0f

    val level = 1 + (completed / 10) // Dette skal laves om til noget andet. Lige nu kommer man i level ved at complete 10 tasks.
                                    // Vi må prøve at lave noget med et levelInterval og et when statement. I er MEGET velkomne til at prøve.

    if (earnedPoints == totalPoints) {
        percentage = 0f
        totalPoints += 125
        viewModel.resetEarnedPoints()
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFACD8F1)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = "Klassens Klima Fremskridt",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(42.dp))

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
            text = "${earnedPoints} point / ${totalPoints} point",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF224B43)
        )

        Spacer(modifier = Modifier.height(42.dp))

        Text(
            text = "Top 3 - Leaderboard",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Elias: Nedenstående fik jeg hjælp til af AI, fordi den ikke ville tage imod viewModel.leaderboard.forEach {}. Don't ask me why

        viewModel.leaderboard.collectAsState().value.forEach { entry ->
            LeaderboardCard(
                rank   = entry.rank,
                name   = entry.name,
                points = entry.points
            )
        }

    }
}