package com.yusufmendes.jetpackcomposewidgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yusufmendes.jetpackcomposewidgets.ui.theme.JetpackComposeWidgetsTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
                    ScreenRadioButton()
                    ScreenProgressIndicator()
                    ScreenSlider()
                    ScreenWebView()
                    ScreenImage()
                    ScreenDropDownMenu()
                    ScreenDynamicDropDownMenu*/
                    PageTransitions()
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
        ScreenRadioButton()
        ScreenProgressIndicator()
        ScreenSlider()
        ScreenWebView()
        ScreenImage()
        ScreenDropDownMenu()
        ScreenDynamicDropDownMenu()*/
    }
}

@Composable
fun PageTransitions() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(navController = navController)
        }
        composable("gameScreen") {
            GameScreen(navController = navController)
        }
        composable("resultScreen/{gameResult}", arguments = listOf(
            navArgument("gameResult") { type = NavType.BoolType }
        )) {
            val gameResult = it.arguments?.getBoolean("gameResult")!!
            ResultScreen(gameResult = gameResult)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Guessing Game",
            fontSize = 32.sp,
            color = Color.DarkGray
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_casino_24),
            contentDescription = ""
        )
        OutlinedButton(onClick = {
            navController.navigate("gameScreen")
        }, modifier = Modifier.size(250.dp, 50.dp)) {
            Text(text = "Start Game", color = Color.DarkGray)
        }
    }
}