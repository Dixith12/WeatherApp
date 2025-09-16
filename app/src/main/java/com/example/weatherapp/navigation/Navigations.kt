package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.screen.detailScreen.DetailScreen
import com.example.weatherapp.screen.homeScreen.HomeScreen
import com.example.weatherapp.screen.SplashScreen
import com.example.weatherapp.screen.searchScreen.SearchScreen
import com.example.weatherapp.viewModel.Viewmodel

@Composable
fun Navigation()
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route)
    {
        composable(Screens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(
            route = Screens.HomeScreen.route + "?city={city}",
            arguments = listOf(
                navArgument("city") {
                    type = NavType.StringType
                    defaultValue = "London"
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val city = backStackEntry.arguments?.getString("city")
            val vm: Viewmodel = hiltViewModel(backStackEntry)
            HomeScreen(navController, city,vm)
        }

        composable(Screens.DetailScreen.route)
        {
            backStackEntry ->
            val vm: Viewmodel = hiltViewModel(backStackEntry)
            DetailScreen(navController,vm)
        }
        composable(Screens.SearchScreen.route) {
            val vm:Viewmodel = hiltViewModel()
            SearchScreen(navController,vm)
        }
    }
}