package com.example.klimaaktion.view.profilescreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.klimaaktion.view.profilescreen.components.ProfileDrawerContent
import com.example.klimaaktion.view.sharedcomponents.BottomNavBar
import kotlinx.coroutines.launch

// Kode skrevet af Felix
@Composable
fun ProfileScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ProfileDrawerContent(
                onClose = { scope.launch { drawerState.close() } },
                onLogout = { /* TODO: log ud */ },
                onLinkClick = { url ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                }
            )
        }
    ) {
        Scaffold(
            bottomBar = {
                BottomNavBar(navController, currentRoute = "profile")
            }
        ) { innerPadding ->
            ProfileScreenContent(
                modifier = Modifier.padding(innerPadding),
                onSettingsClick = {
                    scope.launch { drawerState.open() }
                }
            )
        }
    }
}

