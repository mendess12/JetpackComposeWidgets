package com.yusufmendes.jetpackcomposewidgets

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    /*ScreenButtonTextAndTextField()
                    ScreenFloatingActionButton()
                    ScreenSwitchButton()
                    ScreenCheckBox()
                    ScreenClickable()
                    ScreenRadioButton()*/
                    ScreenProgressIndicator()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeWidgetsTheme {
        /*ScreenButtonTextAndTextField()
        ScreenFloatingActionButton()
        ScreenSwitchButton()
        ScreenCheckBox()
        ScreenClickable()
        ScreenRadioButton()*/
        ScreenProgressIndicator()
    }
}

@Composable
fun ScreenProgressIndicator() {
    val progressState = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (progressState.value) {
            CircularProgressIndicator(
                color = Color.Green,
                modifier = Modifier
                    .padding(top = 64.dp)
                    .background(Color.DarkGray)
            )
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = { progressState.value = true }) {
                Text(text = "Start", color = Color.DarkGray)
            }
            OutlinedButton(onClick = { progressState.value = false }) {
                Text(text = "Stop", color = Color.DarkGray)
            }
        }
    }
}

@Composable
fun ScreenRadioButton() {
    val teamList = listOf("Liverpool", "M.City", "Arsenal", "Chelsea")
    val selectedIndex = remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            teamList.forEachIndexed() { index, team ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RadioButton(
                        selected = (team == teamList[selectedIndex.value]),
                        onClick = {
                            selectedIndex.value = index
                            Log.e("Radio Button", team)
                        })
                    Text(text = team)
                }
            }
        }
    }
}

@Composable
fun ScreenClickable() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .size(120.dp)
            .background(Color.DarkGray)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        Log.e("Box", "Clicked")
                    },
                    onDoubleTap = {
                        Log.e("Box", "Second Clicked")
                    },
                    onLongPress = {
                        Log.e("Box", "Long Clicked")
                    }
                )
            }
        ) {}
    }
}

@Composable
fun ScreenCheckBox() {
    val checkBoxState = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = checkBoxState.value,
                onCheckedChange = {
                    checkBoxState.value = it
                    Log.e("Check Box", checkBoxState.value.toString())
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.DarkGray //check edilmiş halin rengi
                )
            )
            Text(text = "Jetpack Compose", modifier = Modifier.padding(start = 12.dp))
        }
        OutlinedButton(onClick = {
            Log.e(
                "Check Box end state",
                checkBoxState.value.toString()
            )
        }) {
            Text(text = "Show", color = Color.DarkGray)
        }
    }
}

@Composable
fun ScreenSwitchButton() {

    val switchState = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = switchState.value, onCheckedChange = {
                switchState.value = it
                Log.e("Switch", switchState.value.toString())
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,//True durumu yuvarlak kısım
                checkedTrackColor = Color.Red,//True durumu çucuk kısmı
                uncheckedThumbColor = Color.Black,//False durumu yuvarlak kısım
                uncheckedTrackColor = Color.Green//False durumu çubuk kısmı
            )
        )
        Button(onClick = {
            Log.e("Switch End State", switchState.value.toString())
        }) {
            Text(text = "Show", color = Color.DarkGray)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenFloatingActionButton() {
    Scaffold(
        content = {

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Log.e("Fab Button", "Clicked Fab Icon")
                },
                modifier = Modifier.background(Color.LightGray),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            )
        }
    )
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
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        TextField(
            value = textFieldData.value,
            onValueChange = { textFieldData.value = it },
            label = {
                Text(text = "Enter Data")
            },
            colors = TextFieldDefaults.textFieldColors(
                colorResource(id = R.color.orange),
                disabledTextColor = Color.Red,
                focusedIndicatorColor = Color.Green,
                focusedLabelColor = Color.Yellow
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = { getData.value = textFieldData.value },
            colors = ButtonDefaults.buttonColors(
                colorResource(id = R.color.white),
                contentColor = Color.Blue
            ),
            border = BorderStroke(2.dp, Color.Blue),
            shape = RoundedCornerShape(50)
        ) {
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

