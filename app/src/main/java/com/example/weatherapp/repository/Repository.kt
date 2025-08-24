package com.example.weatherapp.repository

import android.util.Log
import com.example.weatherapp.data.DataorException
import com.example.weatherapp.model.WeatherData
import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.room.Fav
import com.example.weatherapp.room.WeatherDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class Repository @Inject constructor(private val api:WeatherApi,
    private val room: WeatherDao
){

    suspend fun getData(city:String):DataorException<WeatherData,Boolean,Exception>
    {
        val dataorException = DataorException<WeatherData,Boolean,Exception>()
        try {
            Log.d("repo","Repos is called")
            dataorException.loading=true
            dataorException.data = api.getData(
                city = city,
            )
            dataorException.loading=false
            Log.d("repo", dataorException.data.toString())
        }
        catch (e:Exception)
        {
           dataorException.exception=e
        }

        return dataorException
    }

    fun getFav(): Flow<List<Fav>> = room.getFav().flowOn(Dispatchers.IO).conflate()

    suspend fun addFav(fav:Fav)
    {
        room.upsert(fav)
    }
}