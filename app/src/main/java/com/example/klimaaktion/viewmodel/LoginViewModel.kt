package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.klimaaktion.model.UserLoginInput

data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val error: String? = null,
    val loading: Boolean = false
)

class LoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onUsernameChange(newValue: String) {
        uiState = uiState.copy(username = newValue, error = null)
    }

    fun onPasswordChange(newValue: String) {
        uiState = uiState.copy(password = newValue, error = null)
    }



    fun login(runLogin: () -> Unit) {
        val input = UserLoginInput(uiState.username.trim(), uiState.password.trim())

        val errorText = input.validate()
        if (errorText != null) {
            uiState = uiState.copy(error = errorText)
            runLogin()
        }

        uiState = uiState.copy(loading = true, error = null)


        if (input.username == "TestUser" && input.password == "password") {
            runLogin()
        } else {
            uiState = uiState.copy(error = "Forkert brugernavn eller adgangskode")
        }

        uiState = uiState.copy(loading = false)
    }
}
