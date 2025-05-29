package com.example.klimaaktion.view.trophyscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.klimaaktion.view.trophyscreen.components.TrophyCard
import com.example.klimaaktion.viewmodel.TrophyViewModel

/**
 * Indholdet for trofæskærmen.
 * Viser både en horisontal billedoversigt og en vertikal liste med detaljerede trofæ-kort.
 * Data hentes fra TrophyViewModel.
 */
@Composable
fun TrophyScreenContent(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: TrophyViewModel = viewModel()
) {
    val trophies = viewModel.trophies

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFACD8F1)) // Ensartet baggrundsfarve som resten af appen
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Overskrift + knap til profilside
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Dine Trofæer",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            IconButton(onClick = { navController.navigate("profilescreen") }) {
                Icon(
                    painter = painterResource(id = com.example.klimaaktion.R.drawable.profilikon),
                    contentDescription = "Profil",
                    modifier = Modifier.size(50.dp),
                    tint = Color.Unspecified
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🏅 Horisontal visning af trofæikoner med transparens for låste trofæer
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
                        .alpha(if (trophy.isCompleted) 1f else 0.3f) // Faded hvis ikke opnået
                )
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            thickness = 1.dp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 📄 Lodret liste over trofæer med beskrivelse og status
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(trophies) { trophy ->
                TrophyCard(trophy = trophy)
            }
        }
    }
}
