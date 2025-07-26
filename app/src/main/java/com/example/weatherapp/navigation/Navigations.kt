package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.screen.HomeScreen
import com.example.weatherapp.screen.SplashScreen

@Composable
fun Navigations() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen()
        }
        composable("HomeScreen") {
            HomeScreen()
        }
        composable("DetailScreen/{City}",
            arguments = listOf(navArgument("city"){type=NavType.StringType})
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city")

        }
    }
}