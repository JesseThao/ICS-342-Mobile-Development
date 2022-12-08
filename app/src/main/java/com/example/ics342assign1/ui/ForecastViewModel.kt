package com.example.ics342assign1.ui

import androidx.lifecycle.ViewModel
import com.example.ics342assign1.models.Forecasts
import com.example.ics342assign1.models.LatitudeLongitude
import com.example.ics342assign1.service.OpenWeatherMapApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {
    private val _forecast = Channel<Forecasts>()

    public val forecast: Flow<Forecasts> = _forecast.receiveAsFlow()

    fun fetchForecastData() = runBlocking {
        val forecast = api.getForecastData("55014")
        _forecast.trySend(forecast)
    }

    fun fetchForecastLocationData(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val forecast = api.getForecastData(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _forecast.trySend(forecast)
    }

}