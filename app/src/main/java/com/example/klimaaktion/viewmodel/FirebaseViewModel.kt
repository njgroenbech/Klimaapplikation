package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klimaaktion.model.firebasemodel.Group
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.model.firebasemodel.Student
import com.example.klimaaktion.network.FirebaseRepository
import kotlinx.coroutines.launch


// Viewmodel skrevet af Nicholas
class FirebaseViewModel(
    private val repo: FirebaseRepository = FirebaseRepository()
): ViewModel() {

    // create state to choose classes from in signup
    var classes by mutableStateOf<List<SchoolClass>>(emptyList())
        private set

    var groups by mutableStateOf<List<Group>>(emptyList())
        private set

    var registerResult by mutableStateOf<Result<Student>?>(null)
        private set

    var loginResult by mutableStateOf<Result<Student>?>(null)
        private set

    // init block sørger for, at all klasser er tilgængelige så snart denne viewmodel er
    // initialized
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

    fun createGroup(classId: String) {
        viewModelScope.launch {
            viewModelScope.launch {
                repo.createGroupInClass(classId, "nyyyyy-gruppe-test", "🧪 Test Grupper")
            }
        }
    }

    fun addPointsToGroupAndClassWhenTaskCompleted(classId: String, groupId: String) {
        viewModelScope.launch {
            repo.addPointsToGroup(classId, groupId, 2)
        }
    }
}