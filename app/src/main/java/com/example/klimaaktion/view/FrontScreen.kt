package com.example.klimaaktion.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

// Hele siden er skrevet af Felix
@Composable
fun FrontScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 40.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.logofrontscreen),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(400.dp)
                    .height(60.dp)
            )

            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                val imageWidth = maxWidth * 1.15f

                Image(
                    painter = painterResource(id = R.drawable.frontscreenimage),
                    contentDescription = "Illustration",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(imageWidth)
                        .padding(top = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6CD59A)),
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    modifier = Modifier
                        .width(220.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = "OPRET BRUGER",
                        color = Color(0xFF343434),
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6CD59A)),
                    elevation = ButtonDefaults.buttonElevation(6.dp),
                    modifier = Modifier
                        .width(220.dp)
                        .height(35.dp)
                ) {
                    Text(
                        text = "ALLEREDE EN BRUGER?",
                        color = Color(0xFF343434),
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
