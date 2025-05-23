package com.example.klimaaktion.view.profilescreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
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

// SKrevet af Felix med meget hjælp fra AI til Drawer funktioner osv
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
            .padding(24.dp)
    ) {
        // Top avatar og navn
        Image(
            painter = painterResource(R.drawable.stefanikon),
            contentDescription = "Bruger avatar",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Stefan", fontWeight = FontWeight.Bold, fontSize = 22.sp)

        Spacer(modifier = Modifier.height(24.dp))

        // Navigation links
        val items = listOf(
            "Inviter til dit hold",
            "Intro til appen",
            "FAQ",
            "Vilkår og betingelser",
            "Privatlivspolitik",
            "Slet konto"
        )

        items.forEach {
            Text(it, fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
            HorizontalDivider()
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Eksterne links
        Text(
            text = "Runddelensriddere.dk",
            color = Color(0xFF6CD59A),
            modifier = Modifier
                .clickable { onLinkClick("https://runddelensriddere.dk") }
                .padding(vertical = 4.dp)
        )

        Text(
            text = "Klimaaktion.dk",
            color = Color(0xFF6CD59A),
            modifier = Modifier
                .clickable { onLinkClick("https://klimaaktion.dk") }
                .padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Log ud
        Text(
            text = "Log ud",
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { onLogout() }
                .padding(vertical = 8.dp)
        )
    }
}
