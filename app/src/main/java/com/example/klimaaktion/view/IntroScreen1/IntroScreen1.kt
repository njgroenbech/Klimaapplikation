package com.example.klimaaktion.view

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
import com.example.klimaaktion.view.IntroScreen1.StartTaskButton
import com.example.klimaaktion.view.components.BottomSection
import com.example.klimaaktion.view.components.TaskCard

@Composable
fun IntroScreen1() {
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

            Spacer(Modifier.height(4.dp))

            Text(
                text = "Klimaaktiviteter og opjen point",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF202020)
            )

            Spacer(Modifier.height(50.dp))
            StartTaskButton(modifier = Modifier.align(Alignment.CenterHorizontally))

            Spacer(Modifier.height(50.dp))
            TaskCard(modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        // BottomSection placement
        BottomSection(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}