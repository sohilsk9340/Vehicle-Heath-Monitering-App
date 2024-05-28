package com.example.vehiclehealthmonetiring

import retrofit.Call
import retrofit.http.GET

interface ApiInterface {
    @GET("status")
    fun getStatus(): Call<StatusData>
}