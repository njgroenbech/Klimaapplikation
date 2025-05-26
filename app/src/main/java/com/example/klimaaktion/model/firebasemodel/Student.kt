package com.example.klimaaktion.model.firebasemodel

// Nicholas har skrevet dette
// Ids er strings, da firebase autogenererer string værdier for
// dokument id'er

data class Student(
    val id: String = "",
    val username: String = "",
    val groupId: String? = null, // null indtil man joiner in gruppe
    val classId: String = ""
)