package com.example.klimaaktion.view.sharedcomponents

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.klimaaktion.R

// Skrevet af Felix, men list huske hjælp fra AI ift. data class & NavItems og NavBarItems
data class NavItem(val route: String, val iconResId: Int)

@Composable
fun BottomNavBar(
    navController: NavController,
    currentRoute: String?
) {
    val items = listOf(
        NavItem("home", R.drawable.homeikon),
        NavItem("feed", R.drawable.barchartikon),
        NavItem("check", R.drawable.opgaveikon),
        NavItem("profile", R.drawable.profilikon)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = null
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
                alwaysShowLabel = false
            )
        }
    }
}
/*
@Composable
fun BottomNavBarPreview() {
    val items = listOf(
        NavItem("home", R.drawable.homeikon),
        NavItem("feed", R.drawable.barchartikon),
        NavItem("check", R.drawable.opgaveikon),
        NavItem("profile", R.drawable.profilikon)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = null
                    )
                },
                selected = item.route == "home", // vælg en som default
                onClick = { /* gør ingenting i preview */ },
                label = null,
                alwaysShowLabel = false
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomNavBar() {
    BottomNavBarPreview()
} */

