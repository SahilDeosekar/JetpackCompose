package com.example.exercise1.utility

import com.example.exercise1.model.Products
import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("products")
    fun getdata(): Call<List<Products>>
}