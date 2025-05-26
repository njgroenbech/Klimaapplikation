package com.example.klimaaktion.view.profilescreen

import android.content.Intent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.klimaaktion.view.profilescreen.components.ProfileDrawerContent
import kotlinx.coroutines.launch
import androidx.core.net.toUri
import com.example.klimaaktion.navigation.Routes


// Kode skrevet af Felix med AI hjælp til Drawer relateret kode
// UI rettet til af Jacob
@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val backgroundColor = Color(0xFFACD8F1)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ProfileDrawerContent(
                onClose = { scope.launch { drawerState.close() } },
                onLogout = { /* Kan tilføjes log ud funktion */ },
                onLinkClick = { url ->
                    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                    context.startActivity(intent)
                }
            )
        }
    ) {
        ProfileScreenContent(
            backgroundColor = backgroundColor,
            onSettingsClick = {
                scope.launch { drawerState.open() }
            },
            onTrophyClick = {
                navController.navigate(Routes.TrophyScren)
            }
        )
    }
}

