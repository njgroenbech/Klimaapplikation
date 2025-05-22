package com.example.klimaaktion.view.introscreen3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R

// Skrevet af Jacob
@Composable
fun TrophyCard(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.trophy),
        contentDescription = "Trophies box",
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
    )
}