package com.example.exercise1.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.exercise1.model.Products
import com.example.exercise1.network.getApiData

class HomeViewModel : ViewModel() {
    private val _productListSate: MutableState<List<Products>> = mutableStateOf(listOf())
    val productListSate: State<List<Products>> = _productListSate

    private val _networkStatusState: MutableState<String> = mutableStateOf("Fetching")
    val networkStatusState: State<String> = _networkStatusState

    fun start() {
        getApiData(_productListSate, _networkStatusState)
    }
}