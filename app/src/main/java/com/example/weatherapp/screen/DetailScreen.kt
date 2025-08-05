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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.weatherapp.R

@Preview
@Composable
fun DetailScreen() {
    Box(modifier= Modifier.fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(
            Color(0xFF2F2383), Color(0xFF443A86), Color(
                0xFFBF4FD7
            )
        ))))
    {

        Column(modifier = Modifier.fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            UpperSection()
            MiddleSection()
            DetailCards()
            WeekCard()
        }

    }
}

@Composable
fun WeekCard() {
    val n=6
    for(i in 0..n)
    {
        RowCard()
    }
}

@Composable
fun RowCard() {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 28.dp))
    {
        Text("Mon",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Row(verticalAlignment = Alignment.CenterVertically)
        {
            Image(painter = painterResource(id = R.drawable.weatherlogo),
                contentDescription = "Image",
                modifier = Modifier.size(70.dp))
            Text("Rainy",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
        }
        Text("+20° +14°",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
    }
}

@Composable
fun MiddleSection() {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth())
    {
        Image(painter = painterResource(id = R.drawable.weatherlogo),
            contentDescription = "Weather",
            modifier = Modifier.size(210.dp))

        Column(modifier = Modifier.fillMaxWidth())
        {
            Text("Tommorrow",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.W400)
            //Annoted String
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontSize = 70.sp, fontWeight = FontWeight.Bold)){
                    append("20")
                }
                withStyle(style = SpanStyle(color = Color.Gray, fontSize = 45.sp, fontWeight = FontWeight.Bold)){
                    append("/20°")
                }
            })
            Text("Sunny",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun UpperSection() {
    Row(modifier = Modifier.fillMaxWidth()
        .padding(vertical = 15.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically)
    {
        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                contentDescription = "IconsBack",
                modifier = Modifier.size(45.dp)
                    .padding(top = 10.dp, bottom = 10.dp, start = 13.dp, end = 8.dp),
                tint = Color.White)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 80.dp))
        {
            Icon(imageVector = Icons.Default.DateRange,
                contentDescription = "DateRange",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(42.dp))
            Text("7 days",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DetailCards() {
    Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
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