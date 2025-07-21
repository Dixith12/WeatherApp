package com.example.weatherapp.model

data class WeatherData(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)