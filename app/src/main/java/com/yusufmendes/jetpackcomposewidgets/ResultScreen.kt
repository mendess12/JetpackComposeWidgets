package com.yusufmendes.jetpackcomposewidgets


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

@Composable
fun ResultScreen(gameResult: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (gameResult) {
            Text(
                text = "You win",
                fontSize = 32.sp,
                color = Color.DarkGray
            )
            Image(
                painter = painterResource(id = R.drawable.mood_icon),
                contentDescription = ""
            )
        } else {
            Text(
                text = "Try again",
                fontSize = 32.sp,
                color = Color.DarkGray
            )
            Image(
                painter = painterResource(id = R.drawable.bad_mood_icon),
                contentDescription = ""
            )
        }
    }
}