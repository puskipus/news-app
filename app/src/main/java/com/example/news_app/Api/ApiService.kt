package com.example.news_app.Api

import com.example.news_app.Models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getNews(
        @Query("country") country : String,
        @Query("category") category : String,
        @Query("q") query : String,
        @Query("apiKey") api_key : String,
    ): Call<NewsResponse>
}