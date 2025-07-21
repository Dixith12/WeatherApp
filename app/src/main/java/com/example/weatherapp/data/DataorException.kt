package com.example.weatherapp.data

import com.example.weatherapp.model.WeatherData

data class DataorException<T,Boolean,E:Exception>(
    var data:WeatherData?=null,
    var loading:Boolean?=null,
    var exception:E?=null)
