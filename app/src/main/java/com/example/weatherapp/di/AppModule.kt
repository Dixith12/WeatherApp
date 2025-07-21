package com.example.weatherapp.di

import com.example.weatherapp.network.WeatherApi
import com.example.weatherapp.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUrl()="https://api.weatherapi.com/v1/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String):Retrofit=
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit):WeatherApi=
        retrofit.create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(api: WeatherApi)= Repository(api)

}