package com.example.exercise1.data

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("products")
    fun getdata():Call<List<Products>>
}