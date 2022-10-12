package com.example.ics342assign1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import com.example.ics342assign1.databinding.FragmentForecastBinding
import kotlin.io.path.createTempDirectory
import kotlin.math.min

class ForecastFragment : Fragment(R.layout.fragment_forecast) {

    private lateinit var binding : FragmentForecastBinding
    /*private val args: ForecastFragmentArgs by navArgs()*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForecastBinding.bind(view)
        /*binding.forecastTemp.text = args.forecast.temp*/

        /*input forecast data in a list here*/
        /*val forecastList = listOf(
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
            DayForecast(),
        )*/

        binding.currentConditionButton.setOnClickListener {
            findNavController().navigate(R.id.action_forecastFragment_to_currentConditionsFragment)
        }

    }



}