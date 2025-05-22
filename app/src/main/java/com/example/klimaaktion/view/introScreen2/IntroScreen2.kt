package com.example.klimaaktion.view.introScreen2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.R
import com.example.klimaaktion.view.IntroScreen1.BottomSection

// Nedenstående kode er skrevet af Elias

@Composable
fun IntroScreen2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFACD8F1))
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
                .fillMaxSize()
                .padding(top = 90.dp)
                .background(Color(0xFFACD8F1))
                .statusBarsPadding()

        ) {
            IntroScreen2Header()

            Spacer(Modifier.height(36.dp))

            IntroScreen2Cards()
        }
    }
}

@Composable
fun IntroScreen2Cards() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.opgaveblock31),
                contentDescription = "Opgave kort",
                modifier = Modifier
                    .size(230.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.quizfield1),
                contentDescription = "Opgave kort",
                modifier = Modifier
                    .size(265.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        BottomSection(1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun IntroScreen2Header() {
    Column {
        Row {
            Text(
                text = "Lær",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(
                text = "Undersøg viden og quiz om klimaet",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

