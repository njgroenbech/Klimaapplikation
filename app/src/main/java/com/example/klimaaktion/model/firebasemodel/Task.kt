package com.example.klimaaktion.model.firebasemodel

// Nicholas har skrevet dette
// Ids er strings, da firebase autogenererer string værdier for
// dokument id'er

data class Task(
    val id: String = "",
    val name: String = "",
    val points: Int = 0
)