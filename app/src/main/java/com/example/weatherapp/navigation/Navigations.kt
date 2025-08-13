package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.screen.detailScreen.DetailScreen
import com.example.weatherapp.screen.homeScreen.HomeScreen
import com.example.weatherapp.screen.SplashScreen

@Composable
fun Navigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route)
    {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Screens.HomeScreen.route) {
            HomeScreen()
        }
        composable(Screens.DetailScreen.route) {
            DetailScreen()
        }
    }
}