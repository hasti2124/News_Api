package com.example.news_api

import com.example.news_api.Models.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("top-headlines")
    fun getNewsInterface(
        @Query("country") country:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String
    ) : Call<NewsModel>
}