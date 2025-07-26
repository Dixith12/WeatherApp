package com.example.weatherapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Column(modifier = Modifier.fillMaxSize())
        {
            UpperSection()
        }

    }
}

@Composable
fun UpperSection() {
    Row(modifier = Modifier.fillMaxWidth()
        .padding(vertical = 10.dp, horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically)
    {
        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBackIos,
                contentDescription = "IconsBack",
                modifier = Modifier.size(45.dp).border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                    .padding(top = 10.dp, bottom = 10.dp, start = 13.dp, end = 8.dp),
                tint = Color.White)
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 70.dp))
        {
            Icon(imageVector = Icons.Default.DateRange,
                contentDescription = "DateRange",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 5.dp)
                    .size(42.dp))
            Text("7 days",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}
