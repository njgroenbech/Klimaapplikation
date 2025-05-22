package com.example.klimaaktion.view.loginscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R

@Composable
fun LogoHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logofrontscreen),
            contentDescription = "KLIMAAKTION Logo",
            modifier = Modifier
                .width(350.dp)
                .height(70.dp)
        )
    }
}
