package com.example.klimaaktion.view.createuserscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.klimaaktion.R
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.model.firebasemodel.Student
import com.example.klimaaktion.view.createuserscreen.components.ClassSelectorButton
import com.example.klimaaktion.view.createuserscreen.components.CreateUserButton
import com.example.klimaaktion.viewmodel.FirebaseViewModel

// Nedenstående kode er lavet af Elias
@SuppressLint("UnusedBoxWithConstraintsScope") // Denne skulle tilføjes, for at bruge BoxWithConstraints
@Composable
fun CreateUserScreen(
    navController: NavController,
    viewModel: FirebaseViewModel = viewModel()
    ) {

    // Nicholas har added kode her, også viewmodel og onRegister
    val classList = viewModel.classes
    val result = viewModel.registerResult
    var selectedClassId by remember { mutableStateOf<SchoolClass?>(null) }

    // Se register resultat
    val registerResult = viewModel.registerResult

    LaunchedEffect(registerResult) {
        registerResult
            ?.onSuccess { student ->
                navController.navigate("LoginScreen") {
                    popUpTo("createUserScreen") { inclusive = true }
                }
            }
    }

    var usernameText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(vertical = 40.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.logofrontscreen),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(400.dp)
                    .height(60.dp)
            )

            Text("Velkommen ${usernameText}")

            // Linje 75-87 er taget fra frontscreen package
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
                        .padding(top = 20.dp)
                        .alpha(0.5f)
                )


                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(0.9f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Opret brugernavn og adgangskode",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = usernameText,
                        onValueChange = {
                             newText -> usernameText = newText },
                        placeholder = {
                            Text("Brugernavn") },
                        shape = RoundedCornerShape(28.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = passwordText,
                        onValueChange = {newText ->
                            passwordText = newText},
                        placeholder = {
                            Text("Adgangskode") },
                        shape = RoundedCornerShape(28.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )

                    // mere nicholas har skrevet
                    ClassSelectorButton(
                        classes = classList,
                        selectedClass = selectedClassId,
                        onSelect = { selectedClassId = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // mere Nicholas
                    registerResult?.onFailure { error ->
                        Text(
                            text = error.localizedMessage ?: "Registrering fejlede",
                            color = Color.Red,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(260.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 160.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            // mere Nicholas, feeder viewModel vores states fra input
            CreateUserButton(
                onClick = {
                    selectedClassId?.let {
                        viewModel.registerStudent(
                            username = usernameText,
                            password = passwordText,
                            classId = it.id
                        )
                    }
                }
            )
        }
    }
}



