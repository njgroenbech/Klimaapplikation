package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

// Skrevet af Felix/Jacob

/**
 * Fremgangsbar-komponent der viser brugerens nuværende point
 * i forhold til et foruddefineret mål (maxPoints).
 *
 * Procenten beregnes og vises som tekst samt grafisk indikator.
 */
@Composable
fun ProfileProgressBar(points: Int = 35, maxPoints: Int = 250) {
    val progress = points.toFloat() / maxPoints               // Procentværdi som float mellem 0 og 1
    val progressPercent = (progress * 100).roundToInt()       // Afrundet procent til visning

    Column(horizontalAlignment = Alignment.Start) {
        // Viser procenten som tekst over progress baren
        Text(
            text = "$progressPercent%",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color(0xFF343434),
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
        )

        // Selve fremgangsbjælken
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
        ) {
            // Grøn del der viser hvor langt brugeren er nået
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress.coerceIn(0f, 1f)) // Sikrer at fremgang aldrig overstiger 100%
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFF2F713C))
            )

            // Centreret tekst inde i fremgangsbjælken
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "$points point ud af $maxPoints",
                    fontSize = 14.sp,
                    color = Color(0xFF343434)
                )
            }
        }
    }
}
