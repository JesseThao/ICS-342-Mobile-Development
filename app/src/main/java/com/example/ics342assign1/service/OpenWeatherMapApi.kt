package com.example.ics342assign1.service

import com.example.ics342assign1.models.CurrentConditions
import com.example.ics342assign1.models.DayForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String ="207a87cc055e036a6a70c2c7a9c5c417",
        @Query("units") units: String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastData(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String ="207a87cc055e036a6a70c2c7a9c5c417",
        @Query("units") units: String = "imperial"
    ) : DayForecast


}