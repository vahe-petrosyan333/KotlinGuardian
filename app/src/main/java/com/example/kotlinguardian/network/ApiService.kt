package com.example.kotlinguardian.network

import com.example.kotlinguardian.response.Example
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("search?show-fields=thumbnail")
     fun getData(): Call<Example>
}