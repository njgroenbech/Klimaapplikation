package com.example.klimaaktion.view.introscreen1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Skrevet af Jacob
@Composable
fun PageIndicator(currentPage: Int = 0, totalPages: Int = 3) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(totalPages) { index ->
            val isSelected = index == currentPage
            Box(
                modifier = Modifier
                    .width(if (isSelected) 24.dp else 14.dp)
                    .height(14.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(Color.Black)
            )
            if (index != totalPages - 1) Spacer(modifier = Modifier.width(10.dp))
        }
    }
}