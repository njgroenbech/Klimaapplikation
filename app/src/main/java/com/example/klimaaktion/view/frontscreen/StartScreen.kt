package com.example.klimaaktion.view.frontscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R


@Composable
fun StartScreen () {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF8ECBEA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(170.dp))

        Image(
            painter = painterResource(id = R.drawable.logofrontscreen),
            contentDescription = "klimaaktion logo",
            modifier = Modifier
                .width(400.dp)
                .height(60.dp)
        )

        Spacer(modifier = Modifier.height(450.dp))

        NextButton {  }
    }
}