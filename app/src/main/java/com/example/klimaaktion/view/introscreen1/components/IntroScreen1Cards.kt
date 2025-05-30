package com.example.klimaaktion.view.introscreen1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.R

// Skrevet af Jacob

/**
 * Viser kort på introduktionsskærm 1:
 * – Et opgavekort med "Start"-knap
 * – Et temakort med illustration og point
 *
 * Formålet er at visualisere handling og belønning i klimaaktiviteter.
 */
@Composable
fun IntroScreen1Cards(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        // StartTaskCard
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .shadow(6.dp, shape = RoundedCornerShape(24.dp))
                .background(color = Color(0xFF7EDC91), shape = RoundedCornerShape(24.dp)),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Tag cyklen i 3 dage",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )

                Box(
                    modifier = Modifier
                        .background(color = Color(0xFF114236), shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Start",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // TransportCard – emnekort med illustration og point
        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(340.dp)
                .shadow(8.dp, shape = RoundedCornerShape(32.dp))
                .background(color = Color(0xFFFFCB5B), shape = RoundedCornerShape(32.dp)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "Transport",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Image(
                    painter = painterResource(id = R.drawable.bicycle),
                    contentDescription = "Cykel ikon",
                    modifier = Modifier.size(120.dp)
                )

                Text(
                    text = "Tag cyklen i 3 dage",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

                Text(
                    text = "30 points",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
