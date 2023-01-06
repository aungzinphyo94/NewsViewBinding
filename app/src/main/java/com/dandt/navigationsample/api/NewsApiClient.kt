package com.dandt.navigationsample.api

import com.dandt.navigationsample.data.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiClient {

    private val BASE_URL = "https://newsapi.org/v2/"

    private var newsApiInterface: NewsApiInterface

    init {
        //Retroit builder function
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //create API Call
        newsApiInterface = retrofit.create(NewsApiInterface::class.java)
    }

    fun getNewsWithQuery(): Call<News> {
        return newsApiInterface.getEverything(
            "tesla",
            "e5a7abe04cb44e41843fc49f810f6591"
        )
    }

}