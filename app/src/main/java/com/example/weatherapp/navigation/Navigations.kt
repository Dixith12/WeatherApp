package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.screen.detailScreen.DetailScreen
import com.example.weatherapp.screen.homeScreen.HomeScreen
import com.example.weatherapp.screen.SplashScreen
import com.example.weatherapp.screen.searchScreen.SearchScreen

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
            HomeScreen(navController)
        }
        composable(Screens.DetailScreen.route,
            arguments = listOf(navArgument("city"){
                NavType.StringType
            })
        ) {
            backStackEntry->
            val city = backStackEntry.arguments?.getString("city")
            DetailScreen(navController,city)
        }
        composable(Screens.SearchScreen.route,) {
            SearchScreen()
        }
    }
}