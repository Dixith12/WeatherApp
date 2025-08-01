package com.example.weatherapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SearchScreen(){
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
            SearchContent()
            HorizontalDivider(modifier = Modifier.padding(top = 15.dp),
                thickness = 2.dp,
                color = Color.White)

            FavoriteContent()
        }
    }
}

@Composable
fun FavoriteContent() {
    Column()
    {
        Text("Favorite Cities :",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp, top = 15.dp))
    }
}

@Composable
fun SearchContent() {
    var search by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 15.dp))
        {
            TextField(value = search,
                onValueChange = {
                    search = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Enter City...")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.Black)
                },
                shape = RoundedCornerShape(50.dp)
            )
        }
        Button(onClick = {

        },
            colors = ButtonDefaults.buttonColors(Color.White)) {
            Text("Search",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }
    }

}
