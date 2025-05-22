package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

@Composable
fun ProfileGroupGrid() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("10%", fontWeight = FontWeight.Bold, color = Color(0xFF343434))
        Spacer(modifier = Modifier.height(4.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
        ) {
            LinearProgressIndicator(
                progress = { 0.14f },
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50)),
                color = Color(0xFF6CD59A),
                trackColor = Color(0xFFF0F0F0)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
        Text("35 point ud af 250", fontSize = 14.sp, color = Color(0xFF343434))

        Spacer(modifier = Modifier.height(12.dp))

        val members = listOf("Johannes", "Torkild", "Zeynab", "Emilie")
        val avatars = listOf(
            R.drawable.johannesikon,
            R.drawable.torkildikon,
            R.drawable.zeynabikon,
            R.drawable.emilieikon
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            modifier = Modifier
                .width(340.dp)
                .height(310.dp)
        ) {
            itemsIndexed(members) { index, name ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .shadow(elevation = 6.dp, shape = RoundedCornerShape(20.dp))
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF6CD59A))
                        .padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = avatars[index]),
                        contentDescription = name,
                        modifier = Modifier.size(90.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(name, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
                }
            }
        }
    }
}

