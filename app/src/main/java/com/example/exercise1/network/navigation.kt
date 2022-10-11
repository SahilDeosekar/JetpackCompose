package com.example.exercise1.network

import androidx.compose.runtime.MutableState
import com.example.exercise1.model.Products
import com.example.exercise1.productList
import com.example.exercise1.utility.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getApiData(productList: MutableState<List<Products>>, networkState: MutableState<String>)    {

    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()
        .create(Apiinterface::class.java)

    val retrofitData = retrofitBuilder.getdata()

    retrofitData.enqueue(object : Callback<List<Products>?> {
        override fun onResponse(call: Call<List<Products>?>, response: Response<List<Products>?>) {

//            if (response.body() != null) productList.value = response.body()!!
            productList.value = response.body() ?: emptyList()
            networkState.value = "Success"
        }

        override fun onFailure(call: Call<List<Products>?>, t: Throwable) {
            productList.value= emptyList()
            networkState.value = "Failed"
        }
    })
}