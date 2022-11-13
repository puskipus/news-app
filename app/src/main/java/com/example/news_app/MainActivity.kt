package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.Api.ApiConfig
import com.example.news_app.Models.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val news = findViewById<RecyclerView>(R.id.recycler_main)

        ApiConfig.getService().getNews("us", "technology", "android", "4d20c02bc3e344b4b108aed4d805d827").enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val responseCode = response.body()
                    val dataNews = responseCode?.articles
                    val newsAdapter = NewsAdapter(dataNews)
                    news.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        newsAdapter.notifyDataSetChanged()
                        adapter = newsAdapter
                    }
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}