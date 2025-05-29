package com.example.klimaaktion.view.createuserscreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.runtime.LaunchedEffect
import com.example.klimaaktion.view.createuserscreen.components.CreateUserScreenContent
import com.example.klimaaktion.viewmodel.FirebaseViewModel

@Composable
fun CreateUserScreen(
    navController: NavController,
    viewModel: FirebaseViewModel = viewModel()
) {
    val registerResult = viewModel.registerResult

    LaunchedEffect(registerResult) {
        registerResult?.onSuccess {
            navController.navigate("LoginScreen") {
                popUpTo("createUserScreen") { inclusive = true }
            }
        }
    }

    CreateUserScreenContent(viewModel = viewModel)
}