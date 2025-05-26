package com.example.klimaaktion.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.klimaaktion.model.Task
import androidx.compose.ui.graphics.Color
import com.example.klimaaktion.R
import com.example.klimaaktion.model.QuizQuestion
import com.example.klimaaktion.model.Trophy

class MainViewModel : ViewModel() {

    // Trophy viewmodel lavet af Jacob
    // Elias: Til TaskScreen
    // quiz relaterede ting og "details" i koden er lavet af Felix
    // Farverne og opgaverne er genereret af AI

    private val listOfTasks = mutableStateListOf(
        Task(
            1,
            "Sluk lyset efter jer!",
            10,
            Color(0xFFFF8080),
            "Vidste du, at man kan spare op til 30 kg CO2 om året ved at slukke lyset?",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            ),
            Trophy(R.drawable.light_trophy_icon, "Sluk lyset i 3 timer!", Color(0xFFFFD9E2), false)
        ),
        Task(2,
            "Plant et træ i gården",
            50,
            Color(0xFFAEA4F2),
            "Et træ absorberer ca. 20 kg CO2 om året.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            ),
            trophy = Trophy(R.drawable.seed_trophy_icon, "Plant et træ i gården", Color(0xFFB7DFFF), false)
        ),
        Task(3,
            "Spis grønt 1 dag",
            40,
            Color(0xFFFFFF99),
            "En kødfri dag kan spare 2 kg CO2.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            )
        ),
        Task(4,
            "Tag cyklen 3 dage",
            35,
            Color(0xFFFFCC66),
            "loremloremloremloremipsiem",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            ),
            Trophy(R.drawable.bike_trophy_icon, "Tag cyklen 3 gange!", Color(0xFFFFD479), true),
        ),
        Task(5,
            "Spis vegetarisk i 2 dage",
            50,
            Color(0xFFA8E6CF),
            "To kødfri dage kan spare miljøet for omkring 5 kg CO2 per person.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            ),
            Trophy(R.drawable.plantbased_trophy_icon, "Spis plante baseret 3 gange!", Color(0xFFD4F4C2), false),
        ),
        Task(6,
            "Undgå madspild i en uge",
            45,
            Color(0xFFB2EBF2),
            "En dansk husstand kan spare over 1.000 kr. om året ved at undgå madspild.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            )        ),
        Task(7,
            "Brug stofpose til indkøb",
            25,
            Color(0xFFD1C4E9),
            "En stofpose kan erstatte over 500 plastikposer i dens levetid.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            )        ),
        Task(8,
            "Sov med slukket elektronik",
            30,
            Color(0xFFFFAB91),
            "Elektronik i standby bruger op til 10% af hjemmets strømforbrug.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            )        ),
        Task(9,
            "Drik vand fra hanen",
            20,
            Color(0xFF80DEEA),
            "Vand på flaske har over 900 gange højere CO2-aftryk end postevand.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            )        ),
        Task(10,
            "Køb brugt i stedet for at købe nyt",
            40,
            Color(0xFFDCEDC8),
            "Deling og køb af brugte ting reducerer affald og produktionens CO2-aftryk markant.",
            "Mere info om opgaven...",
            quiz = listOf(
                QuizQuestion(
                    question = "Hvorfor er træer gode for klimaet?",
                    answers = listOf(
                        "De gør luften mere snavset",
                        "De fanger CO2 fra luften",
                        "De skaber mere ilt i havet"
                    ),
                    correctAnswerIndex = 1
                ),
                QuizQuestion(
                    question = "Hvor meget skov forsvinder hvert år i verden?",
                    answers = listOf(
                        "Ligeså meget som 14 fodboldbaner – hvert minut!",
                        "Ingen skov forsvinder",
                        "Ligeså meget som 10 fodboldbaner"
                    ),
                    correctAnswerIndex = 0
                )
            ),
            Trophy(R.drawable.recycle_trophy_icon, "Find 10 stk. plastik og smid\ndet ud!", Color(0xFFFF6BBC), false),
        )
    )
    val taskList: List<Task> = listOfTasks

    fun completeAndRemoveTask(task: Task) {
        val index = listOfTasks.indexOfFirst { it.id == task.id }

        Log.d("ViewModel", "Modtaget task: ${task.title} med id=${task.id}")

        if (index != -1) {
            val updatedTask = task.copy(isCompleted = true)
            listOfTasks.removeAt(index)

            Log.d("ViewModel", "Task fjernet og markeret som completed: ${updatedTask.title}")
        } else {
            Log.d("ViewModel", "Task IKKE fundet i listen: ${task.title}")
        }
    }
}