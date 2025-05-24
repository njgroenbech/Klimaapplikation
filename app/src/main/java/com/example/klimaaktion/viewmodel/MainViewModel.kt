package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.klimaaktion.model.Task
import androidx.compose.ui.graphics.Color

class MainViewModel : ViewModel() {

    // Elias: Til TaskScreen
    // Farverne og opgaverne er genereret af AI

    private val listOfTasks = mutableStateListOf(
        Task(1, "Sluk lyset efter jer!", 10, Color(0xFFFF8080), "Vidste du, at man kan spare op til 30 kg CO2 om året ved at slukke lyset?"),
        Task(2, "Plant et træ i gården", 50, Color(0xFFAEA4F2), "Et træ absorberer ca. 20 kg CO2 om året."),
        Task(3, "Spis grønt 1 dag", 40, Color(0xFFFFFF99), "En kødfri dag kan spare 2 kg CO2."),
        Task(4, "Tag cyklen 3 dage", 35, Color(0xFFFFCC66), "loremloremloremloremipsiem"),
        Task(5, "Spis vegetarisk i 2 dage", 50, Color(0xFFA8E6CF), "To kødfri dage kan spare miljøet for omkring 5 kg CO2 per person."),
        Task(6, "Undgå madspild i en uge", 45, Color(0xFFB2EBF2), "En dansk husstand kan spare over 1.000 kr. om året ved at undgå madspild."),
        Task(7, "Brug stofpose til indkøb", 25, Color(0xFFD1C4E9), "En stofpose kan erstatte over 500 plastikposer i dens levetid."),
        Task(8, "Sov med slukket elektronik", 30, Color(0xFFFFAB91), "Elektronik i standby bruger op til 10% af hjemmets strømforbrug."),
        Task(9, "Drik vand fra hanen", 20, Color(0xFF80DEEA), "Vand på flaske har over 900 gange højere CO2-aftryk end postevand."),
        Task(10, "Køb brugt i stedet for at købe nyt", 40, Color(0xFFDCEDC8), "Deling og køb af brugte ting reducerer affald og produktionens CO2-aftryk markant.")
    )
    val taskList: List<Task> = listOfTasks

    fun removeTask(task: Task) {
        listOfTasks.remove(task)
    }
}