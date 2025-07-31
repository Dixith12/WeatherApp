package com.example.weatherapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
        }
    }
}

@Composable
fun SearchContent() {
    var search by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.fillMaxWidth()
        .padding(vertical = 30.dp, horizontal = 20.dp))
    {
        TextField(value = search,
            onValueChange = {
                search = it
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "",
                    tint = Color.Black)
            })
    }

}
