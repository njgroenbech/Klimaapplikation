package com.example.klimaaktion.model.firebasemodel

// Nicholas har skrevet dette
// Ids er strings, da firebase autogenererer string værdier for
// dokument id'er

data class Group(
    val groupId: String = "",
    val name: String = "",
    val points: Int = 0,
    val classId: String = "",
    val students: List<String> = emptyList(),
)