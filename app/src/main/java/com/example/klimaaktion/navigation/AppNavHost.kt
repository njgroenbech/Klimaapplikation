package com.example.klimaaktion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.klimaaktion.view.feedscreen.FeedScreen
import com.example.klimaaktion.view.introscreen1.IntroScreen1
import com.example.klimaaktion.view.introscreen2.IntroScreen2
import com.example.klimaaktion.view.introscreen3.IntroScreen3
import com.example.klimaaktion.view.trophyscreen.TrophyScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "TrophyScreen") {
        composable("intro1") { IntroScreen1(navController) }
        composable("intro2") { IntroScreen2(navController) }
        composable("intro3") { IntroScreen3(navController) }
        composable("FeedScreen") { FeedScreen(navController) }
        composable("TrophyScreen") { TrophyScreen(navController) }
    }
}
