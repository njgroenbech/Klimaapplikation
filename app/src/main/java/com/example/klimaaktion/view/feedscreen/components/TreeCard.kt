package com.example.klimaaktion.view.feedscreen.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

// Skrevet af Jacob
@Composable
fun TreeCard() {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color(0xFF6CD59A), shape = RoundedCornerShape(30.dp))
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.hand_world),
                contentDescription = "Jordklode med hånd",
                modifier = Modifier
                    .size(100.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "5 tips til en\ngrønnere hverdag",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 48.sp,
                    color = Color(0xFF202020)
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }

        Text(
            text = "Klimaforlaget.dk",
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://klimaforlaget.dk"))
                    context.startActivity(intent)
                }
        )
    }
}