package com.example.weatherapp.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
fun HomeScreen() {
    Box(modifier= Modifier.fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(
            Color(0xFF2F2383), Color(0xFF443A86), Color(
            0xFFBF4FD7
        )
        ))))
    {
        Column(modifier = Modifier.fillMaxSize())
        {
           HomeScreenContent()
        }

    }
}

@Composable
fun HomeScreenContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth())
    {
        Image(painter = painterResource(id = R.drawable.weatherlogo),
            contentDescription = "",
            modifier = Modifier.size(250.dp))
        Text("19c",
            color = Color.White,
            fontSize = 60.sp,
            fontWeight = FontWeight.Bold)
        Text("Precipitations",
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 5.dp))
        Row()
        {
            Text("Max:24",
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(end=15.dp))
            Text("Min:12",
                color = Color.White,
                fontSize = 25.sp,)
        }
        DetailCard()
    }
}

@Composable
fun DetailCard() {
    Card(modifier = Modifier.padding(top = 20.dp))
    {
        Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 23.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(painter = painterResource(id = R.drawable.wind),
                    contentDescription = "Wind",
                    modifier = Modifier.size(30.dp)
                        .padding(bottom = 5.dp))
                Text("13 km/h",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("Wind",
                    color = Color.Black,
                    fontSize = 16.sp,)

            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .height(40.dp) // make it short
                    .width(3.dp)
                    .background(Color.Gray)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(painter = painterResource(id = R.drawable.humidity),
                    contentDescription = "Wind",
                    modifier = Modifier.size(30.dp)
                        .padding(bottom = 5.dp))
                Text("13 km/h",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("Humidity",
                    color = Color.Black,
                    fontSize = 16.sp,)

            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .height(40.dp) // make it short
                    .width(3.dp)
                    .background(Color.Gray)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(painter = painterResource(id = R.drawable.material),
                    contentDescription = "Wind",
                    modifier = Modifier.size(30.dp)
                        .padding(bottom = 5.dp))
                Text("13 km/h",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("Rain",
                    color = Color.Black,
                    fontSize = 16.sp,)

            }
        }
    }
}
