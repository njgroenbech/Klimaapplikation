package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.model.firebasemodel.Student
import com.example.klimaaktion.network.FirebaseRepository
import kotlinx.coroutines.launch


// Viewmodel skrevet af Nicholas
class FirebaseViewModel(
    private val repo: FirebaseRepository = FirebaseRepository()
): ViewModel() {

    // get classes to choose from in signup
    var classes by mutableStateOf<List<SchoolClass>>(emptyList())
        private set

    var registerResult by mutableStateOf<Result<Student>?>(null)
        private set

    var loginResult by mutableStateOf<Result<Student>?>(null)
        private set

    init {
        viewModelScope.launch {
            classes = repo.getAllClasses()
        }
    }

    fun registerStudent(username: String, password: String, classId: String) {
        registerResult = null

        viewModelScope.launch {
            registerResult = repo.registerStudent(username, password, classId)
        }
    }

    fun loginStudent(username: String, password: String) {
        loginResult = null

        viewModelScope.launch {
            loginResult = repo.loginStudent(username, password)
        }
    }


}