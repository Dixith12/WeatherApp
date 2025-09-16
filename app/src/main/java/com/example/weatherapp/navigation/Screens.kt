package com.example.weatherapp.navigation

sealed class Screens(val route:String) {
    object SplashScreen:Screens("SplashScreen")
    object HomeScreen:Screens("HomeScreen/{city}")
    {
        fun passCity(city:String):String = "HomeScreen/$city"
    }
    object SearchScreen:Screens("SearchScreen")
    object DetailScreen:Screens("DetailScreen/{city}")
    {
        fun passCity(city:String):String = "DetailScreen/$city"
    }

}