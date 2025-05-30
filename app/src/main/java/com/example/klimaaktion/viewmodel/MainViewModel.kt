package com.example.klimaaktion.viewmodel

import com.example.klimaaktion.BuildConfig
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.klimaaktion.model.Task
import androidx.compose.ui.graphics.Color
import com.example.klimaaktion.model.ChatRequest
import com.example.klimaaktion.model.ChatResponse
import com.example.klimaaktion.model.Message
import com.example.klimaaktion.model.QuizQuestion
import com.example.klimaaktion.model.TaskRaw
import com.example.klimaaktion.network.Api
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Response
import androidx.core.graphics.toColorInt
import com.example.klimaaktion.model.Leaderboard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class MainViewModel : ViewModel() {

    // Elias: Til TaskScreen
    // quiz relaterede ting og "details" i koden er lavet af Felix
    // Opgaverne er genereret af AI
    // Build config tilføjet af Nicholas

    //Linje 37-134 er lavet af Felix.

    private val openAIService = Api.openAIService

    val apiKey = "Bearer ${BuildConfig.OPENAI_API_KEY}"

    fun fetchTasksFromOpenAI() {
        Log.d("OpenAITest", "🔁 fetchTasksFromOpenAI() kaldt")
//      Promptets mål indledende var at kunne leverere 10 opgaver i vores LazyList som man kan scroll igennem
        // på baggrund af grundig testning af AI, tests på querytimes og svarindhold.
        // Er vi nået frem til dette prompt som der leverer 4 opgaver uden fejl
        // Og en svar tid der føles naturligt for brugeren i det reele flow.
        // Det er lavet i samarbejde med CHATgpt, og dens inputs på hvordan AI bedst kan læse og forstå hurtigt indhold af promptet.
        // Yderligere dokumentation findes i rapporten
        val prompt = """## OPGAVE

Generér en JSON-liste med præcis 4 klimaopgaver til børn i alderen 10–14 år.  
Returnér **kun gyldig JSON** — ingen ekstra tekst, ingen kommentarer.

---

## FORMATKRAV

Hver opgave skal være et objekt med følgende felter:

- `"id"`: Unikt 2-cifret heltal (alle 4 opgaver skal have forskelligt id)
- `"title"`: Kort og unik titel (en hverdagsopgave, let at forstå)
- `"points"`: Et tal mellem 5 og 50, der er deleligt med 5  
  _(Brug lavere point til nemme opgaver og højere til svære)_
- `"backgroundColor"`: En frugtinspireret hex-farve  
  _(Undgå farver som lyseblå, hvid, sort og mørkegrøn)_
- `"fact"`: En kort faktatekst (maks én linje) om klimaet relateret til opgaven
- `"details"`: En letforståelig forklaring (max 150 ord) om hvorfor opgaven er vigtig for klimaet
- `"quiz"`: En liste med 2 quizspørgsmål. Hvert spørgsmål skal indeholde:
  - `"question"`: Spørgsmålet
  - `"answers"`: Liste med præcis 3 svarmuligheder
  - `"correctAnswerIndex"`: Index på det rigtige svar (0, 1 eller 2)

---

## SÆRLIGE REGLER

- Brug enkelt og børnevenligt sprog.
- `"title"` og `"id"` skal være unikke for hver opgave.
- `"backgroundColor"` skal være inspireret af frugter (fx appelsin, melon, fersken, jordbær).
- Quizspørgsmål skal være forståelige uden at læse hele teksten.
EKSEMPLER PÅ ALLEREDE EKSISTERENDE OPGAVE TITLER -
"Sluk lyset efter jer!"
"Plant et træ i gården"
"Spis grønt 1 dag"
"Tag cyklen 3 dage"
"Spis vegetarisk i 2 dage"
"Sluk elektronik"
"Undgå madspild i en uge"
"Brug stofpose til indkøb"
"Drik vand fra hanen"
"Køb genbrugstøj"
---

## OUTPUT

Returnér en gyldig JSON-array med de 4 opgaver.
Returnér **kun JSON** — ingen ekstra output.

 """.trimIndent()


        val request = ChatRequest(
            model = "gpt-3.5-turbo",
            messages = listOf(
                Message(role = "user", content = prompt)
            ),
            temperature = 0.7,
            max_tokens = 2000
        )


        val call = openAIService.getChatCompletion(apiKey, request)

        call.enqueue(object : retrofit2.Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                val content = response.body()?.choices?.firstOrNull()?.message?.content
                Log.d("OpenAITest", "Raw content:\n$content")

                if (content == null) {
                    Log.e("OpenAITest", "Svar er null")
                    return
                }

                val cleaned = content
                    .replace("```json", "")
                    .replace("```", "")
                    .trim()

                Log.d("OpenAITest", "Cleaned content:\n$cleaned")

                try {
                    val jsonArray = JSONArray(cleaned)
                    Log.d("OpenAITest", "✅ Gyldig JSON-array med ${jsonArray.length()} opgaver")

                    // PARSING til dine egne Task-objekter
                    val tasks = parseTasksFromJson(cleaned)

                    // Opdater den mutable liste, så UI også opdateres
                    listOfTasks.clear()
                    listOfTasks.addAll(tasks)

                } catch (e: Exception) {
                    Log.e("OpenAITest", "⚠️ Parsing-fejl: ${e.message}")
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                Log.e("OpenAITest", "❌ Kald fejlede: ${t.message}", t)
            }

        })
    }

    private fun hexToColor(hex: String): Color {
        return Color(hex.toColorInt())
    }

    private fun parseTasksFromJson(jsonString: String): List<Task> {
        val gson = Gson()
        val type = object : TypeToken<List<TaskRaw>>() {}.type
        val rawList: List<TaskRaw> = gson.fromJson(jsonString, type)

        return rawList.map { raw ->
            Task(
                id = raw.id,
                title = raw.title,
                points = raw.points,
                backgroundColor = hexToColor(raw.backgroundColor),
                fact = raw.fact,
                details = raw.details,
                quiz = raw.quiz
            )
        }
    }


// Linje 139-407 er lavet af både Elias og Felix med hjælp fra AI til at generere opgaverne.

    private val listOfTasks = mutableStateListOf(
        Task(
            1,
            "Sluk lyset efter jer!",
            30,
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
            )
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
            )
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
            "Cykler du i 3 dage, sparer du nok CO₂ til at oplade din iPad 100 gange",
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
            )
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
            "Sluk elektronik",
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
            "Køb genbrugstøj",
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
            )
        )
    )


    // Linje 411- 447 er lavet af Elias.
    val taskList: List<Task> = listOfTasks
    var earnedPointsState = mutableStateOf(0)
    val earnedPoints: State<Int> = earnedPointsState
    val leaderboardState = MutableStateFlow(
        listOf(
            Leaderboard(1, "Klimaklubben", 0),
            Leaderboard(2, "De Grønne Riddere", 0),
            Leaderboard(3, "Eco Eagles", 0)
        )
    ) // Her har jeg hardcoded nogle leaderboard grupper, hvor pointene bliver opdateret i onTaskCompleted funktionen nedenfor.
    val leaderboard: StateFlow<List<Leaderboard>> = leaderboardState

    fun onTaskCompleted(pointsForTask: Int) {

        earnedPointsState.value = earnedPointsState.value + pointsForTask

        val updatedLeaderboard = leaderboardState.value.map { leaderBoardEntry ->
            if (leaderBoardEntry.rank == 1) {
                leaderBoardEntry.copy(points = leaderBoardEntry.points + pointsForTask)
            } else {
                leaderBoardEntry
            }
        } /* Pointsystemet er hardcoded til kun at opdatere én bestemt gruppe.
             Vores intention var, at det skulle afhænge af den gruppe, man havde valgt ved login,
             men vi stødte på udfordringer med at koble pointlogikken op til Firestore.
             Vi uddyber dette i rapportens Develop-kapitel+ konklusionen indeholder referance.
             */


        leaderboardState.value = updatedLeaderboard
    }


    fun removeTask(task: Task) {
        listOfTasks.remove(task)
    }
}