package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klimaaktion.model.firebasemodel.SchoolClass
import com.example.klimaaktion.network.FirebaseRepository
import kotlinx.coroutines.launch

class FirebaseViewModel(
    private val repo: FirebaseRepository = FirebaseRepository()
): ViewModel() {


    var classes by mutableStateOf<List<SchoolClass>>(emptyList())
    private set

    init {
            viewModelScope.launch {
            classes = repo.getAllClasses()
        }
    }

}