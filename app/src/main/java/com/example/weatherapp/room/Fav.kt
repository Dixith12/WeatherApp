package com.example.weatherapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Fav_table")
data class Fav(

    @PrimaryKey
    @ColumnInfo(name = "city")
    val city: String,

)
