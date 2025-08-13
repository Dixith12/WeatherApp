package com.example.weatherapp.room

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.weatherapp.model.WeatherData
import kotlin.uuid.Uuid

@Database(entities = [WeatherData::class],version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase()
{
    abstract fun weatherDao(): WeatherDao
}