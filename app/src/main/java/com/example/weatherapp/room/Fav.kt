package com.example.weatherapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_table")
data class Fav(
    @PrimaryKey
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name= "min")
    val min: Double,
    @ColumnInfo(name = "max")
    val max: Double,
    @ColumnInfo(name = "degree")
    val degree: Double,
)
