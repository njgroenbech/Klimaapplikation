package com.example.klimaaktion.view.introscreen2.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R

// Skrevet af Elias
// UI rettet af Jacob
@Composable
fun IntroScreen2Cards() {
    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.opgaveblock31),
                contentDescription = "Opgave kort",
                modifier = Modifier.size(230.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.quizfield1),
                contentDescription = "Quiz felt",
                modifier = Modifier.size(265.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}