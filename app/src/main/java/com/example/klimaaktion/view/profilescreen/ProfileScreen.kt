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

// Skrevet af Felix med hjælp fra AI til Drawer-funktionalitet.
// UI-justeringer og tilpasninger er lavet af Jacob.

/*
 * Denne Composable repræsenterer den overordnede skærmstruktur for profilsiden.
 * Den håndterer drawer-navigation (sidepanel) og videregiver brugerinteraktioner
 * til `ProfileScreenContent`, som står for det visuelle indhold.
 *
 * View-filen fungerer som skærmens entry point og tager imod en `NavController`
 * til navigation mellem skærme i appen.
 */
@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    // Husk nuværende tilstand for drawer (åben/lukket)
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    // Coroutine scope til at åbne/lukke drawer asynkront
    val scope = rememberCoroutineScope()

    // Kontekst bruges til at starte intent ved klik på link
    val context = LocalContext.current

    // Baggrundsfarve for profilsiden
    val backgroundColor = Color(0xFFACD8F1)

    // ModalNavigationDrawer er en Composable fra Material 3, som skaber en skærm med en skjult sidepanel (drawer),
    // der kan trækkes frem fra venstre side. Den bruges ofte til indstillinger, navigation eller sekundære handlinger.
    // Her bruges den til at vise en brugerdefineret drawer med profilindhold og links.
    // DrawerState styrer om panelet er åbent/lukket, og drawerContent definerer selve indholdet.
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Indholdet i drawer-komponenten
            ProfileDrawerContent(
                onClose = { scope.launch { drawerState.close() } },
                onLogout = { /* TODO: Tilføj log ud-funktion her */ },
                onLinkClick = { url ->
                    // Åbner link i ekstern browser ved klik
                    val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                    context.startActivity(intent)
                }
            )
        }
    ) {
        // Det visuelle hovedindhold på profilsiden
        ProfileScreenContent(
            backgroundColor = backgroundColor,
            onSettingsClick = {
                // Åbner drawer ved klik på tandhjulsikon
                scope.launch { drawerState.open() }
            },
            onTrophyClick = {
                // Navigerer til trofæ-siden
                navController.navigate(Routes.TrophyScren)
            }
        )
    }
}
