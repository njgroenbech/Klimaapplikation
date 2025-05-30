package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
 * Topbjælke på profilsiden med overskrift og to ikoner:
 * – Trofæ (navigerer til trofæoversigt)
 * – Indstillinger (åbner drawer)
 *
 * Modtager to callbacks, som kaldes når brugeren klikker på de respektive ikoner.
 */
@Composable
fun ProfileTopBar(
    onSettingsClick: () -> Unit, // Kaldes når brugeren klikker på indstillingsikonet
    onTrophyClick: () -> Unit    // Kaldes når brugeren klikker på trofæikonet
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Overskrift for profilsiden
        Text(
            text = "Profil",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color(0xFF343434)
        )

        // Højre side af topbaren med ikoner
        Row {
            // Trofæ-ikon med klikbar funktion
            Image(
                painter = painterResource(R.drawable.profiltrophy),
                contentDescription = "Trofæ",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onTrophyClick() }
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Indstillingsikon, åbner drawer via callback
            Image(
                painter = painterResource(R.drawable.settings),
                contentDescription = "Indstillinger",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onSettingsClick() }
            )
        }
    }
}
