package com.example.weatherapp.navigation

sealed class Screens(val route:String) {
    object SplashScreen:Screens("SplashScreen")
    object HomeScreen:Screens("HomeScreen")
    object DetailScreen:Screens("DetailScreen/{City}")
    {
        fun passCity(city:String):String = "DetailScreen/$city"
    }
}