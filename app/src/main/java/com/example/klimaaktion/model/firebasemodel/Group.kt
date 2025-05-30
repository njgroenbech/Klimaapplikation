package com.example.klimaaktion.model.firebasemodel

// Nicholas har skrevet dette
data class Group(
    val id: String = "",
    val name: String = "",
    val points: Int = 0,
    val classId: String = "",
    val students: List<String> = emptyList(),
    val completedTaskIds: MutableList<String> = mutableListOf()
)