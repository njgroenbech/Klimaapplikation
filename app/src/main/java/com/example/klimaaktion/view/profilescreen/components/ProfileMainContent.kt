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
@Composable
fun ProfileMainContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.stefanikon),
            contentDescription = "Avatar",
            modifier = Modifier.size(140.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text("Stefan", fontSize = 38.sp, fontWeight = FontWeight.Bold, color = Color(0xFF343434))
        Text("Klimaklubben", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color(0xFF343434))
        Text("Din gruppe", fontSize = 24.sp, color = Color(0xFF000000))
    }
}

