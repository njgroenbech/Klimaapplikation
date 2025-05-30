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


// Viewmodel skrevet af Nicholas med hjælp fra AI og YouTube tutorials

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

    // init block sørger for, at all klasser er tilgængelige så snart asynkron kode er
    // kørt igennem
    init {
        viewModelScope.launch {
            classes = repo.getAllClasses()
        }
    }

    fun createGroup(groupName: String, classId: String) {
        viewModelScope.launch {
            val created = repo.createGroup(
                Group(
                    name = groupName,
                    classId = classId
                )
            )

            groups = groups + created // opdaterer vores local state i UI

            classes = classes.map {
                if (it.id == classId) it.copy(groups = it.groups + created.id)
                else it
            }
        }
    }

    fun registerStudent(
        username: String,
        password: String,
        classId: String,
        groupId: String?
    ) {

        registerResult = null

        viewModelScope.launch {
            val result = repo.registerStudent(username, password, classId, groupId)
            registerResult = result

            result.onSuccess { student ->
                // update local cache so UI sees the new student in both places
                classes = classes.map {
                    if (it.id == classId) it.copy(students = it.students + student.id)
                    else it
                }
                groupId?.let { gid ->
                    groups = groups.map {
                        if (it.id == gid) it.copy(students = it.students + student.id)
                        else it
                    }
                }
            }
        }
    }

    fun fetchGroupsForClass(classId: String) {
        viewModelScope.launch {
            groups = repo.getGroupsForClass(classId)
        }
    }
}