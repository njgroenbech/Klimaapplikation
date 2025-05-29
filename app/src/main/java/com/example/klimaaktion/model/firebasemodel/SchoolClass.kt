package com.example.klimaaktion.model.firebasemodel

// Nicholas har skrevet dette
data class SchoolClass(
    val id: String = "",
    val name: String = "",
    val points: Int = 0,
    val students: List<String> = emptyList(),
    val groups: List<String> = emptyList()
)