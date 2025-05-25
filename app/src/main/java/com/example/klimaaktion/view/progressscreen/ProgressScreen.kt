package com.example.klimaaktion.view.progressscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.klimaaktion.view.progressscreen.components.CircularProgressBar
import com.example.klimaaktion.view.progressscreen.components.LeaderboardCard
import com.example.klimaaktion.viewmodel.MainViewModel

// Nicholas
@Composable
fun ProgressScreen(navController: NavController,
                   modifier: Modifier = Modifier,
                   viewmodel: MainViewModel = viewModel()) {
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

        CircularProgressBar(0.06f)

        Spacer(modifier = Modifier.height(42.dp))

        Text(
            text = "I er på level 1",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "65 point / 1000 point",
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

        LeaderboardCard(1, "Klimaklubben", 35)

        LeaderboardCard(1, "Klimaklubben", 35)

        LeaderboardCard(1, "Klimaklubben", 35)

    }
}