package com.example.weatherapp.viewModel

import android.util.Log
import androidx.collection.emptyLongSet
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.repository.Repository
import com.example.weatherapp.room.Fav
import com.example.weatherapp.screen.uiState.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(private val repository: Repository): ViewModel(){

    private val _uiState = MutableStateFlow(UiState())
    val UiState : StateFlow<UiState> = _uiState

    private var currentcity = "London"

    init {
        getData(currentcity)
    }

    fun getData(city:String)
    {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true, error = null) }
            currentcity=city
            val res = repository.getData(currentcity)
            _uiState.update {
                it.copy(
                    data = res.data,
                    loading = false,
                    error = res.exception
                )
            }
        }
    }
    fun getFav()
    {
        viewModelScope.launch {
            repository.getFav().distinctUntilChanged().collect{
                listofFav->
                if(listofFav.isEmpty())
                {
                    Log.d("null","Null")
                }
                else
                {
                    _uiState.update { it.copy(loading = true, error = null) }
                    _uiState.update {
                        it.copy(loading = false, fav = listofFav)
                    }
                }
            }
        }
    }

    fun addFav(fav: Fav)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFav(fav)
        }
    }
}