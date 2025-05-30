package com.example.klimaaktion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import com.example.klimaaktion.R
import com.example.klimaaktion.model.Trophy

// Skrevet af Jacob - håndtere og opdatere trofædata
class TrophyViewModel : ViewModel() {

    private val _trophies = mutableStateListOf(
        Trophy(R.drawable.bike_trophy_icon, "Tag cyklen 3 gange!", Color(0xFFFFD479), false),
        Trophy(R.drawable.plantbased_trophy_icon, "Spis plantebaseret!", Color(0xFFA5D6A7), false),
        Trophy(R.drawable.seed_trophy_icon, "Plant et træ!", Color(0xFF81D4FA), false),
        Trophy(R.drawable.light_trophy_icon, "Sluk lyset!", Color(0xFFFFAB91), false),
        Trophy(R.drawable.recycle_trophy_icon, "Sortér affald!", Color(0xFFCE93D8), false),
        Trophy(R.drawable.motivation_trophy_icon, "Motivér en ven!", Color(0xFFFFF9C4), false)
    )

    // Markerer et trofæ som gennemført, hvis det findes og ikke allerede er gennemført.
    fun markTrophyCompleted(index: Int) {
        if (index in _trophies.indices && !_trophies[index].isCompleted) {
            _trophies[index] = _trophies[index].copy(isCompleted = true)
        }
    }

    val trophies: List<Trophy> get() = _trophies
}