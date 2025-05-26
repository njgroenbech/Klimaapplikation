package com.example.klimaaktion.view.feedscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.view.feedscreen.components.GreenDayCard
import com.example.klimaaktion.view.feedscreen.components.RecycleCard
import com.example.klimaaktion.view.feedscreen.components.TreeCard

// Skrevet af Jacob
@Composable
fun FeedScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFACD8F1))
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Feed",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFF202020)
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item { GreenDayCard() }
            item { RecycleCard() }
            item { TreeCard() }

            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}