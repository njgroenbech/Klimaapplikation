package com.example.klimaaktion.view.startscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.klimaaktion.R
import com.example.klimaaktion.view.frontscreen.NextButton


@Composable
fun StartScreen (navController: NavController) {
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

        Spacer(modifier = Modifier.height(200.dp))
        Image(
            painter = painterResource(id = R.drawable.languagebuttons),
            contentDescription = "klimaaktion logo",
            modifier = Modifier
                .width(400.dp)
                .height(130.dp)
        )
        Spacer(modifier = Modifier.height(150.dp))


        NextButton {  }
    }
}