package com.example.weatherapp.screen

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R


data class wether(val degree:String,
    val image:Int,
    val time:String)
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
    val weather = listOf(wether("22",R.drawable.weatherlogo,"10:00"),
        wether("22",R.drawable.weatherlogo,"10:00"),
        wether("22",R.drawable.weatherlogo,"10:00"),
        wether("22",R.drawable.weatherlogo,"10:00"))
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth())
    {
        Image(painter = painterResource(id = R.drawable.weatherlogo),
            contentDescription = "",
            modifier = Modifier.size(290.dp))
        Text("19c",
            color = Color.White,
            fontSize = 65.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 15.dp))
        Text("Precipitations",
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 10.dp))
        Row(modifier = Modifier.padding(bottom = 10.dp))
        {
            Text("Max: 24",
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(end=15.dp))
            Text("Min: 12",
                color = Color.White,
                fontSize = 25.sp,)
        }
        DetailCard()
        Sevendays(weather)
        SevenDayWeathersCard(weather)
    }
}

@Composable
fun SevenDayWeathersCard(weather: List<wether>) {

}

@Composable
fun DetailCard() {
   Box(modifier = Modifier.padding(top = 20.dp)
       .clip(RoundedCornerShape(25.dp))
        .background(brush = Brush.linearGradient(listOf(Color(0xFF2F2383),Color(0xFF443A86),Color(0xFF443A86)))))
    {
        Row(modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(painter = painterResource(id = R.drawable.wind),
                    contentDescription = "Wind",
                    modifier = Modifier.size(30.dp)
                        .padding(bottom = 5.dp),
                    tint = Color.White)
                Text("13 km/h",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("Wind",
                    color = Color.White,
                    fontSize = 16.sp,)

            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .height(40.dp) // make it short
                    .width(4.dp)
                    .background(Color.Gray)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(painter = painterResource(id = R.drawable.humidity),
                    contentDescription = "Wind",
                    modifier = Modifier.size(30.dp)
                        .padding(bottom = 5.dp),
                    tint = Color.White)
                Text("13 km/h",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("Humidity",
                    color = Color.White,
                    fontSize = 16.sp,)

            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .height(40.dp) // make it short
                    .width(4.dp)
                    .background(Color.Gray)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Icon(painter = painterResource(id = R.drawable.material),
                    contentDescription = "Wind",
                    modifier = Modifier.size(30.dp)
                        .padding(bottom = 5.dp),
                    tint = Color.White)
                Text("13 km/h",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("Rain",
                    color = Color.White,
                    fontSize = 16.sp,)

            }
        }
    }
}

@Composable
fun Sevendays(weather: List<wether>)
{
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(top = 30.dp, start = 20.dp,end=10.dp, bottom = 10.dp))
    {
        Text("Today",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Text("7 Days  ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "ArrowBack",
                tint=Color.White)
        }
    }
    LazyRow(modifier = Modifier.fillMaxWidth()
        .padding(vertical = 8.dp, horizontal = 10.dp)
    )
    {
        items(weather){
            item->
            CardDetails(item)
        }
    }

}

@Composable
fun CardDetails(item: wether) {
    Card(modifier = Modifier.padding(end = 5.dp)
        .height(180.dp)
        .width(87.dp),
        shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp, bottomEnd = 50.dp, bottomStart = 50.dp)
    )
    {
        Column(modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(item.degree,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp, top = 10.dp))
            Image(painter = painterResource(id = item.image),
                contentDescription = "Weather Image",
                modifier = Modifier.size(85.dp)
                    .padding(bottom = 5.dp))
            Text(item.time,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp))
        }
    }
}
