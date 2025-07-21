package com.example.weatherapp.repository

import android.util.Log
import com.example.weatherapp.data.DataorException
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.network.WeatherApi
import javax.inject.Inject

class Repository @Inject constructor(private val api:WeatherApi){

    suspend fun getData(city:String):DataorException<WeatherData,Boolean,Exception>
    {
        val dataorException = DataorException<WeatherData,Boolean,Exception>()
        try {
            Log.d("repo","Repos is called")
            dataorException.loading=true
            dataorException.data = api.getData(city)
            dataorException.loading=false
            Log.d("repo", dataorException.data.toString())
        }
        catch (e:Exception)
        {
           dataorException.exception=e
        }

        return dataorException
    }
}