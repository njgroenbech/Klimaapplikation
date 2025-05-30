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

/**
 * Indholdet på loginskærmen, opdelt i tre komponenter:
 * – LogoHeader: viser logo/branding
 * – LoginForm: tekstfelter og valideringsfejl
 * – LoginButton: starter login-processen
 *
 * Interagerer direkte med LoginViewModel og sender brugerdata videre.
 */
// Skrevet af Laurits
@Composable
fun LoginScreenContent(
    navController: NavController,
    viewModel: LoginViewModel = viewModel() // ViewModel binder input og loginlogik
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(35.dp))

        // Øverste logo/branding-komponent
        LogoHeader()

        Spacer(modifier = Modifier.height(70.dp))

        // Formular til brugernavn og kodeord
        LoginForm(
            username = viewModel.username,
            onUsernameChange = viewModel::onUsernameChange, // Kaldes når brugernavn ændres
            password = viewModel.password,
            onPasswordChange = viewModel::onPasswordChange, // Kaldes når kodeord ændres
            errorMessage = viewModel.error // Viser evt. valideringsfejl
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Knap der forsøger login og navigerer videre ved succes
        LoginButton(
            onClick = {
                viewModel.login {
                    navController.navigate("feedscreen")
                }
            }
        )
    }
}
