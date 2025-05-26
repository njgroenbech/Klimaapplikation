package com.example.klimaaktion.view.loginscreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.klimaaktion.view.loginscreen.components.LoginButton
import com.example.klimaaktion.view.loginscreen.components.LoginForm
import com.example.klimaaktion.view.loginscreen.components.LogoHeader
import com.example.klimaaktion.viewmodel.LoginViewModel

@Composable
fun LoginScreenContent(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        LogoHeader()
        Spacer(modifier = Modifier.height(70.dp))

        LoginForm(
            username = viewModel.username,
            onUsernameChange = viewModel::onUsernameChange,
            password = viewModel.password,
            onPasswordChange = viewModel::onPasswordChange,
            errorMessage = viewModel.error
        )

        Spacer(modifier = Modifier.height(100.dp))

        LoginButton(
            onClick = {
                viewModel.login {
                    navController.navigate("feedscreen")
                }
            }
        )
    }
}
