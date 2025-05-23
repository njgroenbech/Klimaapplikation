package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.klimaaktion.model.Task
import androidx.compose.ui.graphics.Color

class MainViewModel : ViewModel() {

    // Elias: Til TaskScreen

    private val listOfTasks = mutableStateListOf(
        Task(1, "Sluk lyset efter jer!", 10, Color(0xFFFF8080), "Vidste du, at man kan spare op til 30 kg CO2 om året ved at slukke lyset?"),
        Task(2, "Plant et træ i gården", 50, Color(0xFFAEA4F2), "Et træ absorberer ca. 20 kg CO2 om året."),
        Task(3, "Spis grønt 1 dag", 40, Color(0xFFFFFF99), "En kødfri dag kan spare 2 kg CO2."),
        Task(4, "Tag cyklen 3 dage", 35, Color(0xFFFFCC66), "loremloremloremloremipsiem")
    )
    val taskList: List<Task> = listOfTasks

    fun removeTask(task: Task) {
        listOfTasks.remove(task)
    }
}