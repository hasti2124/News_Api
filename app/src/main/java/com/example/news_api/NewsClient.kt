package com.example.news_api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsClient {
    companion object{
        val BASE_URL = "https://newsapi.org/v2/"
        lateinit var retrofit : Retrofit

        fun getNewsClient(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}