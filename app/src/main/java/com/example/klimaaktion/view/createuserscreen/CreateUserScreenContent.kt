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
import com.example.klimaaktion.model.firebasemodel.Group
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.viewmodel.FirebaseViewModel
// Lavet af Elias og Nicholas
@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CreateUserScreenContent(
    viewModel: FirebaseViewModel = viewModel()
) {
    val classList = viewModel.classes
    var selectedClassId by remember { mutableStateOf<SchoolClass?>(null) }
    val groupList = viewModel.groups
    var selectedGroup by remember { mutableStateOf<Group?>(null) }
    val registerResult = viewModel.registerResult

    var usernameText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    LaunchedEffect(selectedClassId) {
        selectedClassId?.let {
            viewModel.fetchGroupsForClass(it.id)
            selectedGroup = null
        }
    }

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
                        onValueChange = { usernameText = it },
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
                        onValueChange = { passwordText = it },
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
                        selectedClass = selectedClassId,
                        onSelect = { selectedClassId = it }
                    )

                    if (selectedClassId != null) {
                        CreateGroupButton {
                            viewModel.createGroup(it, selectedClassId!!.id)
                        }
                        GroupSelectorButton(
                            groups = groupList,
                            selectedGroup = selectedGroup,
                            onSelect = { selectedGroup = it }
                        )
                    } else {
                        Spacer(modifier = Modifier.height(96.dp))
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
            CreateUserButton {
                selectedClassId?.let {
                    viewModel.registerStudent(
                        username = usernameText,
                        password = passwordText,
                        classId = it.id,
                        groupId = selectedGroup?.id
                    )
                }
            }
        }
    }
}