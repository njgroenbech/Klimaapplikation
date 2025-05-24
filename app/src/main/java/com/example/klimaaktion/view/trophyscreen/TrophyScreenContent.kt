package com.example.klimaaktion.view.trophyscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.klimaaktion.view.trophyscreen.components.HeaderNav
import com.example.klimaaktion.view.trophyscreen.components.HorizontalTrophyList
import com.example.klimaaktion.view.trophyscreen.components.cards.BikeCard
import com.example.klimaaktion.view.trophyscreen.components.cards.LightCard
import com.example.klimaaktion.view.trophyscreen.components.cards.MotivationCard
import com.example.klimaaktion.view.trophyscreen.components.cards.PlantFoodCard
import com.example.klimaaktion.view.trophyscreen.components.cards.SeedCard
import com.example.klimaaktion.view.trophyscreen.components.cards.TrashCard
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.klimaaktion.viewmodel.TrophyViewModel

@Composable
fun TrophyScreenContent(
    navController: NavController,
    viewModel: TrophyViewModel = viewModel()
) {
    val trophies = viewModel.trophies

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFA3E6F7))
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        HeaderNav(
            onTrophyClick = { /* Navigér til trofæ-skærm */ },
            onSettingsClick = { /* Åbn indstillinger */ }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Send data til horizontal liste
        HorizontalTrophyList(trophies = trophies)

        Spacer(modifier = Modifier.height(22.dp))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //  Brug trofæerne fra ViewModel
            item { BikeCard(isCompleted = trophies[0].isCompleted) }
            item { PlantFoodCard(isCompleted = trophies[1].isCompleted) }
            item { SeedCard(isCompleted = trophies[2].isCompleted) }
            item { LightCard(isCompleted = trophies[3].isCompleted) }
            item { TrashCard(isCompleted = trophies[4].isCompleted) }
            item { MotivationCard(isCompleted = trophies[5].isCompleted) }
        }
    }
}