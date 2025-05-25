package com.example.klimaaktion.view.trophyscreen.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import com.example.klimaaktion.R

// Skrevet af Jacob
@Composable
fun PlantFoodCard(
    isCompleted: Boolean = false,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .alpha(if (isCompleted) 1f else 0.3f)
            .background(
                color = Color(0xFFFEFFAD),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.plantbased_trophy_icon),
                    contentDescription = "Plant Food Icon",
                    modifier = Modifier.size(48.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Spis plante baseret 3 gange!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            if (isCompleted) {
                Icon(
                    painter = painterResource(id = R.drawable.checkmark_icon),
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