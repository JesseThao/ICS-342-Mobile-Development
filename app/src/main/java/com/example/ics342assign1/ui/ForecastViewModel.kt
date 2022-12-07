package com.example.ics342assign1.ui

import androidx.lifecycle.ViewModel
import com.example.ics342assign1.models.DayForecast
import com.example.ics342assign1.service.OpenWeatherMapApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {
    private val _forecast = Channel<DayForecast>()

    public val forecast: Flow<DayForecast> = _forecast.receiveAsFlow()

    fun fetchData() = runBlocking {
        val forecast = api.getForecastData("55014")
        _forecast.trySend(forecast)
    }


}