package com.example.klimaaktion.view.feedscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

// Skrevet af Jacob
@Composable
fun GreenDayCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(Color(0xFF6CD59A), shape = RoundedCornerShape(30.dp))
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "Plant et træ\ni jeres\nskolegård",
                    fontSize = 37.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 40.sp,
                    color = Color(0xFF202020),
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(id = R.drawable.water_guy),
                    contentDescription = "Træ ikon",
                    modifier = Modifier
                        .height(200.dp)
                        .width(150.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "En nem og hyggelig måde at gøre noget godt for klimaet",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF202020)
            )
        }
    }
}