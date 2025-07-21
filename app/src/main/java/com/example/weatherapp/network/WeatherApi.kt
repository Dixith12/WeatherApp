package com.example.weatherapp.network

import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET("forecast.json")
    suspend fun getData(
        @Query("key") apiKey: String = Constants.ApiKey,
        @Query("q") city: String,
        @Query("days") days: Int = 7,
        @Query("aqi") aqi: String = "no",
        @Query("alerts") alerts: String = "no"
    ): WeatherData
}