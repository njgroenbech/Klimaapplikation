package com.example.klimaaktion.view.sharedcomponents

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.klimaaktion.R
import com.example.klimaaktion.navigation.Routes

// Skrevet af Felix, men list huske hjælp fra AI ift. data class & NavItems og NavBarItems
// UI rettet til af Nicholas
// UI rettet til af Jacob
data class NavItem(val route: String, val iconResId: Int)

@Composable
fun BottomNavBar(
    navController: NavController,
    currentRoute: String?
) {
    val items = listOf(
        NavItem(Routes.Feed, R.drawable.homeikon),
        NavItem(Routes.Progress, R.drawable.barchartikon),
        NavItem(Routes.Tasks, R.drawable.opgaveikon),
        NavItem(Routes.Profile, R.drawable.profilikon)
    )

    NavigationBar(
        modifier = Modifier
            .height(70.dp),
        tonalElevation = 4.dp
    ) {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(top = 13.dp)
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                label = null,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF6BE173),
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = Color.Transparent // fjerne forblvende bobbel animation
                )
            )
        }
    }
}