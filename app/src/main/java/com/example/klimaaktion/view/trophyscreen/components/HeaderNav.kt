package com.example.klimaaktion.view.trophyscreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
fun HeaderNav(
    onTrophyClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Trofæer",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onTrophyClick) {
                Icon(
                    painter = painterResource(id = R.drawable.profilikon),
                    tint = Color.Unspecified,
                    contentDescription = "Profil",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}