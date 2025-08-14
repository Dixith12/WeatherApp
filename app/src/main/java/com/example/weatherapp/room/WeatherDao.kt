package com.example.weatherapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(fav: Fav)

    @Query("DELETE FROM fav_table WHERE city = :city")
    suspend fun deleteFavByCity(city: String)

    @Query("SELECT EXISTS(SELECT 1 FROM fav_table WHERE city = :city LIMIT 1)")
    fun isFavourite(city: String): Flow<Boolean>

    @Query("Select * from Fav_table")
    fun getFav(): Flow<List<Fav>>

}