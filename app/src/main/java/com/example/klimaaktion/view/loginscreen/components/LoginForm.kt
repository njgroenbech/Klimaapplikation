package com.example.klimaaktion.view.loginscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun LoginForm(
    username: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    errorMessage: String?
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val imageWidth = maxWidth * 1.15f

        Image(
            painter = painterResource(id = R.drawable.frontscreenimage),
            contentDescription = "Illustration",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(imageWidth)
                .padding(top = 35.dp)
                .alpha(0.22f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Log ind med dit brugernavn og adgangskode",
                color = Color(0xFF343434),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(22.dp))

            OutlinedTextField(
                value = username,
                onValueChange = onUsernameChange,
                label = { Text("Brugernavn") },
                placeholder = { Text("Brugernavn") },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text("Adgangskode") },
                placeholder = { Text("Adgangskode") },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

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
