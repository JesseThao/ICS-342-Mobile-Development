package com.example.ics342assign1.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ics342assign1.R
import com.example.ics342assign1.R.string

@Composable
fun CurrentConditions(
    onForecastButtonClick: () -> Unit,
) {
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.city_name),
            style = TextStyle(
                fontWeight = FontWeight(600),
                fontSize = 24.sp
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.current_temp),
                    style = TextStyle(
                        fontWeight = FontWeight(400),
                        fontSize = 72.sp,
                    )
                )
                Text(
                    text = stringResource(id = R.string.feels_like_temp, 110),
                    style = TextStyle(
                        fontSize = 12.sp,
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f, fill = true))
            Image(
                modifier = Modifier.size(72.dp),
                painter = painterResource(R.drawable.sun_icon),
                contentDescription = "Sunny"
            )

        }
        Spacer(modifier = Modifier.height(24.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            val textStyle = TextStyle(
                fontSize = 16.sp,
            )
            Text(text = stringResource(id = R.string.low_temp, 98), style = textStyle)
            Text(text = stringResource(id = R.string.high_temp, 110), style = textStyle)
            Text(text = stringResource(id = R.string.humidity, 78), style = textStyle)
            Text(text = stringResource(id = R.string.pressure, 1023), style = textStyle)
        }
        Spacer(modifier = Modifier.height(72.dp))
        Button(onClick = onForecastButtonClick) {
            Text(text = stringResource(id = R.string.forecast))
        }
    }
}


@Preview (
    showSystemUi = true
)
@Composable
fun CurrentConditionsPreview() {
    CurrentConditions {}
}
