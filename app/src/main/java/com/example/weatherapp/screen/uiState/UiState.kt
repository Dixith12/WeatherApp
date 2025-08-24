package com.example.weatherapp.screen.uiState

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.room.Fav

data class UiState(val data: WeatherData?=null,
                   val fav:List<Fav> = emptyList(),
                   val loading:Boolean=false,
                   val error:Exception?=null)
