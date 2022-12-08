package com.example.ics342assign1.models

import com.squareup.moshi.Json

data class DayForecast(
    val date: Long,
    val sunrise: Long,
    val sunset: Long,
    val forecastTemp: ForecastTemp,
    val pressure: Float,
    val humidity: Int,
)

data class ForecastTemp(
    val min: Float,
    val max: Float
)

