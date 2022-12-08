package com.example.ics342assign1.models

import com.squareup.moshi.Json

data class ForecastTemperatures(
    @Json(name = "max") val maxTemperature: Float,
    @Json(name = "min") val minTemperature: Float,
)

data class ForecastsData(
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val temperatures: ForecastTemperatures,
    @Json(name = "weather") val weatherIconImage: List<WeatherIcon>,

    )

data class WeatherIcon(
    @Json(name = "icon") val iconName: String
)

data class Forecasts(
    @Json(name = "list") val DailyForecastData: List<ForecastsData>,

    )
