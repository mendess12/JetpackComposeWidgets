package com.yusufmendes.jetpackcomposewidgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController) {
    val numberOfForecastsRemaining = remember { mutableStateOf(5) }
    val randomNumber = remember { mutableStateOf(0) }
    val helper = remember { mutableStateOf("") }
    val forecast = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LaunchedEffect(key1 = true) {
            randomNumber.value = Random.nextInt(101)
        }
        Text(
            text = "Number Of Forecasts Remaining : ${numberOfForecastsRemaining.value}",
            fontSize = 24.sp,
            color = Color.DarkGray
        )
        Text(
            text = "Help : ${helper.value}",
            fontSize = 18.sp,
            color = Color.DarkGray
        )
        OutlinedTextField(
            value = forecast.value,
            onValueChange = { forecast.value = it },
            label = {
                Text("Forecast")
            })
        OutlinedButton(onClick = {
            numberOfForecastsRemaining.value = numberOfForecastsRemaining.value - 1
            val getForecast = forecast.value.toInt()
            if (getForecast == randomNumber.value) {
                navController.navigate("resultScreen/true") {
                    popUpTo("gameScreen") { inclusive = true }
                }
                return@OutlinedButton
            }
            if (getForecast > randomNumber.value) {
                helper.value = "Reduce"
            }
            if (getForecast < randomNumber.value) {
                helper.value = "Increase"
            }
            if (numberOfForecastsRemaining.value == 0) {
                navController.navigate("resultScreen/false") {
                    popUpTo("gameScreen") { inclusive = true }
                }
            }
            forecast.value = ""

        }, modifier = Modifier.size(250.dp, 50.dp)) {
            Text(text = "Guess", color = Color.DarkGray)
        }
    }
}