package com.example.klimaaktion.view.frontscreen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.klimaaktion.navigation.Routes


// Skrevet af Felix
@Composable
fun FrontScreenButtons(navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        Button(
            onClick = { navController.navigate("createUserScreen") },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6CD59A)),
            elevation = ButtonDefaults.buttonElevation(6.dp),
            modifier = Modifier
                .width(220.dp)
                .height(50.dp)
        ) {
            Text(
                text = "OPRET BRUGER",
                color = Color(0xFF343434),
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { navController.navigate("loginscreen") },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6CD59A)),
            elevation = ButtonDefaults.buttonElevation(6.dp),
            modifier = Modifier
                .width(220.dp)
                .height(35.dp)
        ) {
            Text(
                text = "ALLEREDE EN BRUGER?",
                color = Color(0xFF343434),
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = { navController.navigate(Routes.Feed) },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF9A9A)),
            elevation = ButtonDefaults.buttonElevation(6.dp),
            modifier = Modifier
                .width(220.dp)
                .height(35.dp)
        ) {
            Text(
                text = "ADMIN ADGANG",
                color = Color(0xFF343434),
                fontSize = 12.sp
            )
        }
    }
}
