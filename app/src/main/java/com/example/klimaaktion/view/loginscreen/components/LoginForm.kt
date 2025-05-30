package com.example.klimaaktion.view.loginscreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

/**
 * Formular-komponent til loginskærmen.
 * Indeholder felter til brugernavn og adgangskode, samt visning af fejlbesked.
 * Baggrundsbilledet vises svagt for visuel effekt, uden at forstyrre UI.
 */
// Skrevet af Laurits
@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun LoginForm(
    username: String,
    onUsernameChange: (String) -> Unit,   // Kaldes når brugernavn opdateres
    password: String,
    onPasswordChange: (String) -> Unit,   // Kaldes når adgangskode opdateres
    errorMessage: String?                 // Vises, hvis der er en fejl i login
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val imageWidth = maxWidth * 1.15f // Gør billedet lidt bredere end skærmen for visuel effekt

        // Illustrativ baggrundsfigur (svag gennemsigtighed)
        Image(
            painter = painterResource(id = R.drawable.frontscreenimage),
            contentDescription = "Illustration",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(imageWidth)
                .padding(top = 35.dp)
                .alpha(0.22f)
        )

        // Formularens faktiske indhold
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Introduktionstekst
            Text(
                text = "Log ind med dit brugernavn og adgangskode",
                color = Color(0xFF343434),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Brugernavn-tekstfelt
            OutlinedTextField(
                value = username,
                onValueChange = onUsernameChange,
                label = { Text("Brugernavn") },
                placeholder = { Text("Brugernavn") },
                shape = RoundedCornerShape(28.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Adgangskode-tekstfelt (skjult input)
            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text("Adgangskode") },
                placeholder = { Text("Adgangskode") },
                shape = RoundedCornerShape(28.dp),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Fejlmeddelelse vises kun hvis errorMessage ikke er null
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp),
                contentAlignment = Alignment.Center
            ) {
                if (errorMessage != null) {
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                }
            }
        }
    }
}
