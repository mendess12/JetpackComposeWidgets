package com.yusufmendes.jetpackcomposewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.yusufmendes.jetpackcomposewidgets.ui.theme.JetpackComposeWidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeWidgetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenButtonTextAndTextField()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeWidgetsTheme {
        ScreenButtonTextAndTextField()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenButtonTextAndTextField() {

    val textFieldData = remember { mutableStateOf("") }
    val getData = remember { mutableStateOf("") }
    val outLinedTextFieldData = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Incoming Data : ${getData.value} ",
            modifier = Modifier.background(Color.Green),
            color = Color.Black
        )
        TextField(
            value = textFieldData.value,
            onValueChange = { textFieldData.value = it },
            label = {
                Text(text = "Enter Data")
            })

        Button(onClick = { getData.value = textFieldData.value }) {
            Text(text = "Get Data")

        }
        OutlinedTextField(
            value = outLinedTextFieldData.value,
            onValueChange = { outLinedTextFieldData.value = it },
            label = {
                Text(text = "Enter Data")
            })

        OutlinedButton(onClick = { getData.value = outLinedTextFieldData.value }) {
            Text(text = "Get Data")

        }
    }
}

