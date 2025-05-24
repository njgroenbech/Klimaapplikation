package com.example.klimaaktion.view.trophyscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.model.Trophy

@Composable
fun HorizontalTrophyList(trophies: List<Trophy>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(trophies) { trophy ->
            Image(
                painter = painterResource(id = trophy.iconRes),
                contentDescription = "Trofæ ikon",
                modifier = Modifier
                    .size(94.dp)
                    .alpha(if (trophy.isCompleted) 1f else 0.3f)
            )
        }
    }
}