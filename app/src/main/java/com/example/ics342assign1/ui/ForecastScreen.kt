package com.example.ics342assign1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ics342assign1.R
import com.example.ics342assign1.models.DayForecast
import com.example.ics342assign1.models.ForecastTemp
import com.example.ics342assign1.toHourMinute
import com.example.ics342assign1.toMonthDay

val startDay = 166581430L
val sunrise = 1664953200L
val sunset = 1664996400L

val forecastData = (0 until 16).map {
    DayForecast(
        date = startDay + (it * (24 * 60 * 60)),
        sunrise = sunrise + (it * 24 * 60 * 60),
        sunset = sunset + (it * 24 * 60 * 60),
        forecastTemp = ForecastTemp(min = 70f + it, max = 80f + it),
        pressure = 1024f,
        humidity = 76,
    )
}

@Composable
fun ForecastScreen() {
    LazyColumn {
        items(items = forecastData) { item: DayForecast ->
        }
    }
}

@Composable
private fun ForecastRow(item: DayForecast) {

    Row(
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )
        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Spacer(modifier = Modifier.weight( 1f, fill = true))
        Text(
            text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.weight( 9f, fill = true))
        Column {
            Text(
                text = stringResource(id = R.string.high_temp, item.forecastTemp.max.toInt()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.low_temp, item.forecastTemp.min.toInt()),
                style = textStyle,
            )
        }
        Spacer(modifier = Modifier.weight( 1f, fill = true))
        Column(
            horizontalAlignment = Alignment.End
        )
        {
            Text(
                text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(
                text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
                style = textStyle,
            )
        }
    }
}

@Preview (
    showSystemUi = true
)
@Composable
private fun ForecastRowPreview() {
    ForecastRow(item = forecastData[0])
}