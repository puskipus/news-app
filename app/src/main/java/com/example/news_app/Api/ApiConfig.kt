package com.example.news_app.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    const val baseUrl = "https://newsapi.org/v2/"

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}