package com.example.weatherapp.screen.searchScreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.weatherapp.navigation.Screens
import com.example.weatherapp.room.Fav
import com.example.weatherapp.viewModel.Viewmodel

@Composable
fun SearchScreen(navController: NavController, vm: Viewmodel){

    LaunchedEffect(Unit) {
        vm.getFav()
    }

    val data = vm.UiState.collectAsStateWithLifecycle()
    Box(modifier= Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(brush = Brush.linearGradient(listOf(
            Color(0xFF2F2383), Color(0xFF443A86), Color(
                0xFFBF4FD7
            )
        ))))
    {
        Column(modifier = Modifier.fillMaxSize())
        {
            SearchContent(navController,vm)
            HorizontalDivider(modifier = Modifier.padding(top = 15.dp),
                thickness = 2.dp,
                color = Color.White)

            FavoriteContent(data.value.fav,navController,vm)
        }
    }
}

@Composable
fun FavoriteContent(data: List<Fav>, navController: NavController, vm: Viewmodel) {
    Column()
    {
        Text("Favorite Cities :",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp, bottom = 15.dp))

        data.forEach {
                item->
            ContainCard(item,vm)
        }

    }
}

@Composable
fun ContainCard(item: Fav, vm: Viewmodel) {

    var showdialog by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    if (showdialog) {
        AlertDialog(
            onDismissRequest = { showdialog = false },
            title = { Text("Delete Favourite") },
            text = { Text("Are you sure you want to delete this?") },
            confirmButton = {
                Text(
                    "Delete",
                    color = Color.Red,
                    modifier = Modifier
                        .clickable {

                            showdialog = false
                            Toast.makeText(context,"Note Removed", Toast.LENGTH_SHORT).show()
                        }
                        .padding(8.dp)
                )
            },
            dismissButton = {
                Text(
                    "Cancel",
                    modifier = Modifier
                        .clickable { showdialog = false }
                        .padding(8.dp)
                )
            }
        )
    }
    Card(modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 5.dp),
        colors = CardDefaults.cardColors(Color.White)
        )
    {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp),
            )
        {
            Column()
            {
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Icon(imageVector = Icons.Default.LocationOn,
                        contentDescription = "",
                        modifier = Modifier.size(25.dp))
                    Text(
                        item.city,
                        fontSize = 23.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black
                    )
                }

                    Text("Max: ${item.max}/Min: ${item.min}",fontSize = 20.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 10.dp, top = 15.dp))
            }
            Text("${item.degree}°c",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(end = 5.dp))
        }
    }
}

@Composable
fun SearchContent(navController: NavController, viewmodel: Viewmodel) {
    var search by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(top = 70.dp, start = 20.dp, end = 20.dp, bottom = 15.dp))
        {
            TextField(value = search,
                onValueChange = {
                    search = it
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text("Enter City...",
                        color = Color.Black)
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Black)
                },
                shape = RoundedCornerShape(50.dp),
                colors = TextFieldDefaults.colors(focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White)
            )
        }
        Button(onClick = {
            navController.navigate(Screens.HomeScreen.passCity(search))
        },
            colors = ButtonDefaults.buttonColors(Color.White)) {
            Text("Search",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }
    }

}
