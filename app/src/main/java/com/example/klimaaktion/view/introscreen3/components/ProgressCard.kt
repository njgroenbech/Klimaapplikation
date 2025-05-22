package com.example.klimaaktion.view.introscreen3.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R

@Composable
fun ProgressCard(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.intro_card),
        contentDescription = "Progress box",
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp)
    )
}