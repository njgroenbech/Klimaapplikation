package com.example.klimaaktion.view.loginscreen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.sp

/**
 * Knap til login-handling.
 * Udløser en callback-funktion ved klik, som håndterer login og navigation.
 * Designet med afrundede hjørner og grøn baggrund for at signalere handling.
 */
// Skrevet af Laurits
@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick, // Kaldes når brugeren klikker på knappen
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6CD59A)),
        elevation = ButtonDefaults.buttonElevation(6.dp),
        modifier = Modifier
            .width(240.dp)
            .height(54.dp)
    ) {
        Text(
            text = "LOG IND",
            color = Color(0xFF343434),
            fontSize = 18.sp
        )
    }
}
