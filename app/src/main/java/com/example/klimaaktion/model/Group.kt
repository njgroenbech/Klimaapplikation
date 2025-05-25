package com.example.klimaaktion.model

data class Group(
    val id: Int,
    val name: String,
    val completedTaskIds: MutableList<Int> = mutableListOf()
)