package com.example.klimaaktion.view.frontscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R


@Composable
fun FrontScreenImages() {

    Image(
        painter = painterResource(id = R.drawable.logofrontscreen),
        contentDescription = "Logo",
        modifier = Modifier
            .width(400.dp)
            .height(60.dp)
    )


    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        val imageWidth = maxWidth * 1.15f // Gør billedet lidt bredere end skærmen

        Image(
            painter = painterResource(id = R.drawable.frontscreenimage),
            contentDescription = "Illustration",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(imageWidth)
                .padding(top = 20.dp)
        )
    }
}
