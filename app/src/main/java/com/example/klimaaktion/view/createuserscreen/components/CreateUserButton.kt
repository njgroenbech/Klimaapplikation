package com.example.klimaaktion.view.createuserscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Skrevet af Nicholas
@Composable
fun CreateUserButton(onClick: () -> Unit) {
    // Knappen er taget fra frontscreen.components.Buttons
    Button(
        onClick = onClick,
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
}

