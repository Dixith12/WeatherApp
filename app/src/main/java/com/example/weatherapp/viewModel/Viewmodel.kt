package com.example.weatherapp.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(private val repository: Repository): ViewModel(){
    fun getData(city:String)
    {
        viewModelScope.launch {
            val result = repository.getData(city)
        }
    }
}