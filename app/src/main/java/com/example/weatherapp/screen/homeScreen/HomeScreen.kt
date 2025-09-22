package com.example.weatherapp.screen.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.model.Current
import com.example.weatherapp.model.Hour
import com.example.weatherapp.model.Location
import com.example.weatherapp.navigation.Screens
import com.example.weatherapp.room.Fav
import com.example.weatherapp.screen.uiState.UiState
import com.example.weatherapp.viewModel.Viewmodel

@Composable
fun HomeScreen(
    navController: NavController,
    city: String?,
    viewModel: Viewmodel
) {

    LaunchedEffect(city) {
        viewModel.getData(city ?: "London")
    }

    val data = viewModel.UiState.collectAsStateWithLifecycle()

    Box(modifier= Modifier.fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(
            Color(0xFF2F2383), Color(0xFF443A86), Color(
            0xFFBF4FD7
        )
        ))))
    {
        when{
            data.value.loading->{
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    CircularProgressIndicator(strokeWidth = 2.dp,
                        color = Color.White)
                }
            }
            data.value.data==null->
            {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text("No Data Found",
                        color= Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold)
                }

            }
            else ->
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    HomeScreenContent(data, navController,viewModel)
                }
            }
        }

    }
}

@Composable
fun HomeScreenContent(data: State<UiState>, navController: NavController, viewModel: Viewmodel) {
    val city = data.value.data?.location
    val current = data.value.data?.current
    val forecast = data.value.data?.forecast
    val location = data.value.data?.location
    val favsList = data.value.fav
    var isalready = favsList.any { it.city==city.toString() }
    val hours = data.value.data?.forecast?.forecastday?.firstOrNull()?.hour.orEmpty()

    val rawIcon = current?.condition?.icon ?: ""
    val highResIcon = rawIcon.replace("64x64", "128x128")

    val minPrecip = hours.minOfOrNull { it.precip_mm } ?: 0.0
    val maxPrecip = hours.maxOfOrNull { it.precip_mm } ?: 0.0
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth())
    {

        Row(modifier = Modifier.fillMaxWidth()
            .padding(start = 15.dp, top = 50.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = Color.White,
                modifier = Modifier.size(38.dp)
                    .clickable {
                        navController.navigate(Screens.SearchScreen.route)
                    })

            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Icon(imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = Color.White)
                if (location != null) {
                    Text(location.name,
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold)
                }
            }
            Icon(imageVector = if(isalready)Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Add",
                tint = if(isalready)Color.Red else Color.White,
                modifier = Modifier.size(40.dp).clickable {
                    isalready=!isalready
                    val fav = current?.let {
                        forecast?.forecastday?.get(0)?.day?.let { it1 ->
                            location?.let { it2 ->
                                Fav(
                                    it2.name,
                                    it1.mintemp_c,
                                    forecast.forecastday[0].day.maxtemp_c,
                                    it.temp_c)
                            }
                        }
                    }
                    if (fav != null) {
                        viewModel.addFav(fav)
                    }
                })

        }
        if (current != null) {
            AsyncImage(model = "https:$highResIcon",
                contentDescription = "",
                modifier = Modifier.size(270.dp))
        }
        if (current != null) {
            Text("${current.temp_c}°c",
                color = Color.White,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 15.dp))
        }
        Text("Precipitations",
            color = Color.White,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 10.dp))
        Row(modifier = Modifier.padding(bottom = 10.dp))
        {
            Text("Max: ${"%.1f".format(maxPrecip)} mm",
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier.padding(end=15.dp))
            Text("Min: ${"%.1f".format(minPrecip)} mm",
                color = Color.White,
                fontSize = 25.sp,)
        }
        DetailCard(current)
        if (forecast != null) {
            Sevendays(forecast.forecastday[0].hour,navController,city)
        }
    }
}

@Composable
fun DetailCard(current: Current?) {
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
                if (current != null) {
                    Text("${current.wind_kph} km/h",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                }
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
                Text("${current?.humidity} %",
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
                if (current != null) {
                    Text("${current.precip_mm} mm",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)
                }
                Text("Rain",
                    color = Color.White,
                    fontSize = 16.sp,)

            }
        }
    }
}

@Composable
fun Sevendays(weather: List<Hour>, navController: NavController, city: Location?)
{
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(top = 30.dp, start = 20.dp,end=10.dp, bottom = 10.dp))
    {
        Text("Today",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
              navController.navigate(Screens.DetailScreen.route)
            })
        {
            Text("3 Days  ",
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
fun CardDetails(item: Hour) {

    val hour = item.time.substringAfter(" ").substringBefore(":").toInt()
    val pros = if (hour in 12..23) "PM" else "AM"
    Card(modifier = Modifier.padding(end = 5.dp)
        .height(150.dp)
        .width(87.dp),
        shape = RoundedCornerShape(topEnd = 50.dp, topStart = 50.dp, bottomEnd = 50.dp, bottomStart = 50.dp),
        colors = CardDefaults.cardColors(Color.White)
    )
    {
        Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text("${item.temp_c}°c",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp, top = 10.dp))
            AsyncImage(model="https:" + (item.condition.icon ?: ""),
                contentDescription = "Weather Image",
                modifier = Modifier.size(63.dp)
                    .padding(bottom = 5.dp))
            Text("${hour % 12} $pros",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp))
        }
    }
}
