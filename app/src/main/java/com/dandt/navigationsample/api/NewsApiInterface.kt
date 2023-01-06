package com.dandt.navigationsample.api

import com.dandt.navigationsample.data.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("everything")
    fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String
    ): Call<News>

}