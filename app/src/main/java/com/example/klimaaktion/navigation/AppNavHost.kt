package com.example.klimaaktion.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.klimaaktion.view.feedscreen.FeedScreen
import com.example.klimaaktion.view.frontscreen.FrontScreen
import com.example.klimaaktion.view.introscreen1.IntroScreen1
import com.example.klimaaktion.view.introscreen2.IntroScreen2
import com.example.klimaaktion.view.introscreen3.IntroScreen3
import com.example.klimaaktion.view.loginscreen.LoginScreen
import com.example.klimaaktion.view.profilescreen.ProfileScreen
import com.example.klimaaktion.view.progressscreen.ProgressScreen
import com.example.klimaaktion.view.sharedcomponents.BottomNavBar
import com.example.klimaaktion.view.startscreen.StartScreen
import com.example.klimaaktion.view.taskscreen.TaskScreen
import com.example.klimaaktion.view.trophyscreen.TrophyScreen


@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "startScreen") {
        composable("startScreen") {StartScreen(navController)}
        composable("frontScreen") {FrontScreen(navController) }
        composable("intro1") { IntroScreen1(navController) }
        composable("intro2") { IntroScreen2(navController) }
        composable("intro3") { IntroScreen3(navController) }
        composable("LoginScreen") { LoginScreen(navController) }
        composable("TrophyScreen") { TrophyScreen(navController) }

        // Tilføje navbar til bunden af skærme (Nicholas)
        composable(Routes.Feed) {
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController = navController, currentRoute = Routes.Feed)
                }
            ) {
                innerPadding ->
                FeedScreen(navController, modifier = Modifier.padding(innerPadding))
            }
        }


        composable(Routes.Progress) {
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController = navController, currentRoute = Routes.Progress)
                }
            ) {
                    innerPadding ->
                ProgressScreen(navController, modifier = Modifier.padding(innerPadding))
            }
        }

        composable(Routes.Tasks) {
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController = navController, currentRoute = Routes.Tasks)
                }
            ) {
                    innerPadding ->
                TaskScreen(navController = navController,
                    modifier = Modifier.padding(innerPadding))
            }
        }

        composable(Routes.Profile) {
            Scaffold(
                bottomBar = {
                    BottomNavBar(navController = navController, currentRoute = Routes.Profile)
                }
            ) {
                    innerPadding ->
                ProfileScreen(navController, modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
