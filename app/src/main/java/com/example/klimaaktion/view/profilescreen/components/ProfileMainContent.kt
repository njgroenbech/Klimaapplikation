package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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

// Skrevet af Felix
// UI rettet til af Jacob

/**
 * Viser brugerens primære profilindhold:
 * – Avatarbillede
 * – Brugernavn
 * – Gruppetilhørsforhold
 *
 * Bruges centralt på profilsiden som visuel introduktion til brugeren.
 */
@Composable
fun ProfileMainContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Avatar-ikon for brugeren (midlertidigt hardkodet til "Stefan")
        Image(
            painter = painterResource(R.drawable.stefanikon),
            contentDescription = "Avatar",
            modifier = Modifier.size(140.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Brugernavn
        Text(
            text = "Stefan",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF343434)
        )

        // Gruppenavn (evt. klasse eller hold)
        Text(
            text = "Klimaklubben",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF343434)
        )

        // Forklaringstekst under gruppenavnet
        Text(
            text = "Din gruppe",
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}
