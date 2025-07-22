package com.example.weatherapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Preview
@Composable
fun SplashScreen() {
    Box(modifier=Modifier.fillMaxSize()
    .background(brush = Brush.linearGradient(listOf(Color(0xFF2F2383),Color(0xFF443A86),Color(
        0xFFBF4FD7
    )
    ))))
    {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            WeatherSplash()
        }

    }
}

@Composable
fun WeatherSplash() {
    Image(painter = painterResource(id = R.drawable.weatherlogo),
        contentDescription = "",
        modifier = Modifier.size(380.dp))
    Text("Weather",
        color = Color.White,
        fontSize = 60.sp,
        fontWeight = FontWeight.Bold,)
    Text("Forecast",
        color = Color(0xFFEED019),
        fontSize = 60.sp,
        fontWeight = FontWeight.SemiBold,)
    Button(colors = ButtonDefaults.buttonColors(Color(0xFFEED019)),
        onClick = {

    }, modifier = Modifier.padding(top = 100.dp)){
        Text("Get Start",
            modifier = Modifier.padding(vertical = 7.dp, horizontal = 40.dp),
            color = Color(0xFF2F2383),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold)
    }
}
