package com.example.klimaaktion.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.klimaaktion.R
import com.example.klimaaktion.model.Trophy
import androidx.compose.ui.graphics.Color

class TrophyViewModel : ViewModel() {

    private val _trophies = mutableStateListOf(
        Trophy(R.drawable.bike_trophy_icon, "Tag cyklen 3 gange!", Color(0xFFFFD479), false),
        Trophy(R.drawable.plantbased_trophy_icon, "Spis plante baseret 3 gange!", Color(0xFFD4F4C2), false),
        Trophy(R.drawable.seed_trophy_icon, "Plant et træ i gården!", Color(0xFFB7DFFF), false),
        Trophy(R.drawable.light_trophy_icon, "Sluk lyset i 3 timer!", Color(0xFFFFD9E2), false),
        Trophy(R.drawable.recycle_trophy_icon, "Find 10 stk. plastik og smid\ndet ud!", Color(0xFFFF6BBC), false),
        Trophy(R.drawable.motivation_trophy_icon, "Har du motiveret nogen i dag?", Color(0xFFB5F2EA), false)
    )

    val trophies: List<Trophy> get() = _trophies

    fun markTrophyCompleted(index: Int) {
        if (index in _trophies.indices) {
            _trophies[index] = _trophies[index].copy(isCompleted = true)
        }
    }
}