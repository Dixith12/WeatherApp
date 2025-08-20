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
        composable(Screens.HomeScreen.route, arguments = listOf(navArgument("City"){
            NavType.StringType
        })) {
            backStackEntry->
            val city = backStackEntry.arguments?.getString("City")
            HomeScreen(navController,city)
        }
        composable(Screens.DetailScreen.route)
        {
            DetailScreen(navController)
        }
        composable(Screens.SearchScreen.route) {
            val vm:Viewmodel = hiltViewModel()
            SearchScreen(navController,vm)
        }
    }
}