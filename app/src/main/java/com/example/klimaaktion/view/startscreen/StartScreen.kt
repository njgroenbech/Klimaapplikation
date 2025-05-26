package com.example.klimaaktion.view.startscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.klimaaktion.R
import com.example.klimaaktion.view.sharedcomponents.NextButton

// Lavet af Jacob
@Composable
fun StartScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(170.dp))

            Image(
                painter = painterResource(id = R.drawable.logofrontscreen),
                contentDescription = "klimaaktion logo",
                modifier = Modifier
                    .width(400.dp)
                    .height(60.dp)
            )

            Spacer(modifier = Modifier.height(200.dp))

            Image(
                painter = painterResource(id = R.drawable.languagebuttons),
                contentDescription = "sprog knapper",
                modifier = Modifier
                    .width(400.dp)
                    .height(130.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            NextButton { navController.navigate("intro1") }
        }
    }
}