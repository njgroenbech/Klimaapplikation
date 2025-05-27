package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klimaaktion.model.UserLogin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.klimaaktion.network.FirebaseRepository
import com.example.klimaaktion.model.firebasemodel.Student


class LoginViewModel(
    private val repo: FirebaseRepository = FirebaseRepository()
) : ViewModel() {

    var student by mutableStateOf<Student?>(null)
        private set
    var username by mutableStateOf("Obi-Wan-Kenobi")
        private set
    var password by mutableStateOf("kodeord")
        private set
    var error by mutableStateOf<String?>(null)
        private set


    fun onUsernameChange(newValue: String) {
        username = newValue
        error = null
    }
    fun onPasswordChange(newValue: String) {
        password = newValue
        error = null
    }

    private fun validateFields(username: String, password: String): String? {
        if (username.isBlank()) return "Indtast brugernavn"
        if (password.isBlank()) return "Indtast adgangskode"
        if (username.length < 3) return "Brugernavn skal være mindst 3 tegn"
        if (password.length < 6) return "Adgangskode skal være mindst 6 tegn"
        return null
    }

    fun login(runLogin: () -> Unit) {

        //  runlogin bruges her så ikke login endnu
        val inputUsername = username.trim()
        val inputPassword = password.trim()

        val validationResult = validateFields(inputUsername, inputPassword)
        if (validationResult != null) {
            error = validationResult
            return
        }
        //input i dataclass
        val loginData = UserLogin(username = inputUsername, password = inputPassword)

        error = null
// alt her er lidt ligegyldigt
        viewModelScope.launch {
            val result = repo.loginStudent(loginData.username,loginData.password)
            if (result.isSuccess) {
                student = result.getOrNull()
                runLogin() // kør navigation logik
            } else {
                error = "Login eksisterer ikke"
            }
        }
    }
}
