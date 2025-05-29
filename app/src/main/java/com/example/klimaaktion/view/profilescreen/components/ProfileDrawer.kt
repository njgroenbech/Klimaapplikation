package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klimaaktion.R

// Skrevet af Felix med meget hjælp fra AI til Drawer-funktioner
// UI rettet til af Jacob

/**
 * Drawer-indhold til profilsiden.
 * Viser brugeroplysninger, informationslinks, logout-knap og sprogvalg.
 *
 * Modtager tre callbacks:
 * – onClose: bruges til at lukke drawer (ikke brugt her endnu, da man bare kan klikke uden for draweren,
 * og så lukker draweren af sig selv.
 * – onLogout: kaldes når brugeren klikker på "Log ud", gør dog ikke noget endnu
 * – onLinkClick: kaldes når brugeren klikker på et eksternt link
 */
@Composable
fun ProfileDrawerContent(
    onClose: () -> Unit,
    onLogout: () -> Unit,
    onLinkClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(280.dp)
            .background(Color.White)
            .padding(top = 80.dp)
            .padding(24.dp)
    ) {
        Column {
            // Avatar og brugeroplysninger
            Image(
                painter = painterResource(R.drawable.stefanikon),
                contentDescription = "Bruger avatar",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Stefan",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp
            )
            Text(
                text = "Inviter til dit hold",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(12.dp))

            // Liste over informationslinks (hardcoded løsning så klikfunktion mangler)
            val items = listOf(
                "Intro til appen",
                "FAQ",
                "Vilkår og betingelser",
                "Privatlivspolitik",
                "Slet konto"
            )

            items.forEach {
                Text(
                    text = it,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(vertical = 6.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(12.dp))

            // Eksterne links – kalder callback med URL
            Text(
                text = "Runddelensriddere.dk",
                color = Color(0xFF6CD59A),
                fontSize = 18.sp,
                modifier = Modifier
                    .clickable { onLinkClick("https://runddelensriddere.dk") }
                    .padding(vertical = 4.dp)
            )
            Text(
                text = "Klimaaktion.dk",
                color = Color(0xFF6CD59A),
                fontSize = 18.sp,
                modifier = Modifier
                    .clickable { onLinkClick("https://klimaaktion.dk") }
                    .padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Log ud-knap (rød og tydelig)
            Text(
                text = "Log ud",
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .clickable { onLogout() }
                    .padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Sprogvalg med flagikoner (funktionalitet mangler pt.)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(R.drawable.flag_dk),
                contentDescription = "Dansk",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { /* Skift sprog til dansk (TODO) */ }
            )
            Image(
                painter = painterResource(R.drawable.flag_uk),
                contentDescription = "Engelsk",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { /* Skift sprog til engelsk (TODO) */ }
            )
        }
    }
}
