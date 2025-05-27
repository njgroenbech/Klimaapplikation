package com.example.klimaaktion.view.trophyscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.klimaaktion.model.Trophy

// Skrevet af Jacob
@Composable
fun TrophyCard(trophy: Trophy) { // <- ændret fra Task til Trophy
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .alpha(if (trophy.isCompleted) 1f else 0.3f)
            .background(trophy.backgroundColor, RoundedCornerShape(20.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = trophy.iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = trophy.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            if (trophy.isCompleted) {
                Icon(
                    painter = painterResource(id = com.example.klimaaktion.R.drawable.checkmark_icon),
                    contentDescription = "Fuldført",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(Color.Transparent)
                        .border(width = 2.dp, color = Color.Black, shape = CircleShape)
                )
            }
        }
    }
}