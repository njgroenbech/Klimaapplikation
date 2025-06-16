package com.example.klimaaktion.view.createuserscreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.klimaaktion.R
import com.example.klimaaktion.viewmodel.FirebaseViewModel

// Lavet af Elias og Nicholas. AI/tutorials som hjælpemiddel til at få indført funktionalitet

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CreateUserScreenContent(
    viewModel: FirebaseViewModel = viewModel()
) {
    val classList = viewModel.classes
    val selectedClass = viewModel.selectedClass
    val groupList = viewModel.groups
    val selectedGroup = viewModel.selectedGroup
    val registerResult = viewModel.registerResult
    val usernameText by viewModel.usernameText
    val passwordText by viewModel.passwordText

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
                    .width(350.dp)
                    .height(70.dp)
            )

            Text("Velkommen ${usernameText}")

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
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = usernameText,
                        onValueChange = viewModel::onUsernameChange,
                        placeholder = { Text("Brugernavn") },
                        shape = RoundedCornerShape(28.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = passwordText,
                        onValueChange = viewModel::onPasswordChange,
                        placeholder = { Text("Adgangskode") },
                        shape = RoundedCornerShape(28.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    ClassSelectorButton(
                        classes = classList,
                        selectedClass = selectedClass.value,
                        onSelect = viewModel::onClassSelectedFromUI
                    )

                    if (selectedClass.value != null) {
                        CreateGroupButton(
                            onCreate = viewModel::onCreateGroupClick
                        )

                        GroupSelectorButton(
                            groups = groupList,
                            selectedGroup = selectedGroup.value,
                            onSelect = viewModel::onGroupSelectedFromUI
                        )
                    } else {
                        Spacer(modifier = Modifier.height(96.dp)) // sørger for UI ikke bliver rykket op
                    }

                    registerResult?.onFailure {
                        Text(
                            text = it.localizedMessage ?: "Registrering fejlede",
                            color = Color.Red,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(280.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 160.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            CreateUserButton(
                onClick = viewModel::onCreateUserClick
            )
        }
    }
}