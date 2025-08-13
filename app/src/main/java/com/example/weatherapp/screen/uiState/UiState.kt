package com.example.weatherapp.screen.uiState

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weatherapp.model.WeatherData

data class UiState(val data: WeatherData?=null,
                   val loading:Boolean=false,
                   val error:Exception?=null)
