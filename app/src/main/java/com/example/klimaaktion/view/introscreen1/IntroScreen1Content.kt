package com.example.klimaaktion.view.introscreen1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.view.introscreen1.IntroScreen1Cards
import com.example.klimaaktion.view.sharedcomponents.NextButton
import com.example.klimaaktion.view.sharedcomponents.PageIndicator

// Skrevet af Jacob
@Composable
fun IntroScreen1Content(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF94D7F2))
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Udfør",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF202020)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Klimaaktiviteter og optjen point",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF202020)
            )

            Spacer(modifier = Modifier.height(12.dp)) // matcher Intro 2 & 3

            IntroScreen1Cards(navController = navController)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            PageIndicator(currentPage = 0)
            Spacer(modifier = Modifier.height(20.dp))
            NextButton { navController.navigate("intro2") }
        }
    }
}