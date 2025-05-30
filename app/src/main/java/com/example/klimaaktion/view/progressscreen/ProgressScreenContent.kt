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

// UI rettet til af Jacob
// UI lavet af Nicholas.
// Funktionalitet tilføjet af Elias: Linje 30-73

@Composable
fun ProgressScreenContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {

    val earnedPoints by viewModel.earnedPoints // Denne her variabel indhenter de aktuelle antal point gruppen har optjent fra staten i MainViewModel.

    val currentLevel = when (earnedPoints) {
        in 0..175 -> 1
        in 175..350 -> 2
        in 350..525 -> 3
        in 525..700 -> 4
        in 700..875 -> 5
        in 875..1050 -> 6
        else -> "Maks Level"
    }

    val levelStartPoints = when (currentLevel) {
        1 -> 0
        2 -> 175
        3 -> 350
        4 -> 525
        5 -> 700
        6 -> 875
        else -> 1050
    }

    val levelEndPoints = when (currentLevel) {
        1 -> 175
        2 -> 350
        3 -> 525
        4 -> 700
        5 -> 875
        6 -> 1050
        else -> 1200
    }

    // De to ovenstående variabler bruges til at udregne progressionen for det pågældende level i "cirkularProgressionBar" længere nede i UI'et.

    val classLevelProgress = earnedPoints - levelStartPoints
    val classLevelTotalPoints = levelEndPoints - levelStartPoints

    var percentage = classLevelProgress.toFloat() / classLevelTotalPoints

    if (percentage == 100f) {
        percentage = 0f
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
            text = "I er på level $currentLevel",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "$earnedPoints point / $levelEndPoints point",
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

        // Elias: Nedenstående fik jeg hjælp til af AI ift. syntaks, da jeg fik lidt problemer med mit oprindelige.

        viewModel.leaderboard.collectAsState().value.forEach { leaderBoardEntry ->
            LeaderboardCard(
                rank = leaderBoardEntry.rank,
                name = leaderBoardEntry.name,
                points = leaderBoardEntry.points
            )
        }
    }
}