package com.example.klimaaktion.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomSection(
    currentPage: Int = 0,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // Page Indicator
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            repeat(3) { index ->
                val isSelected = index == currentPage
                Box(
                    modifier = Modifier
                        .width(if (isSelected) 24.dp else 14.dp)
                        .height(14.dp)
                        .clip(RoundedCornerShape(7.dp))
                        .background(Color.Black)
                )
                if (index != 2) Spacer(modifier = Modifier.width(10.dp))
            }
        }

        // Forward button
        Box(
            modifier = Modifier
                .size(80.dp)
                .shadow(10.dp, CircleShape, clip = false)
                .clip(CircleShape)
                .background(Color(0xFF7EDC91)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Videre",
                tint = Color.White,
                modifier = Modifier.size(65.dp)
            )
        }
    }
}