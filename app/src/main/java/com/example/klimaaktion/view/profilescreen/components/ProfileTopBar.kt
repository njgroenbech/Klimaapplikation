package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
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
@Composable
fun ProfileTopBar(onSettingsClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Trofæer",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = Color(0xFF343434)
        )

        Row {
            Image(
                painter = painterResource(R.drawable.profiltrophy),
                contentDescription = "Trofæ",
                modifier = Modifier.size(40.dp),
                colorFilter = null
            )
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                painter = painterResource(R.drawable.settings),
                contentDescription = "Indstillinger",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onSettingsClick() }, // 👈 NYT
                colorFilter = null
            )

        }
    }
}

