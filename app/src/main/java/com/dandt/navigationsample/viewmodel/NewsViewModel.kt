package com.dandt.navigationsample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dandt.navigationsample.api.NewsApiClient
import com.dandt.navigationsample.data.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel: ViewModel() {

    private var news: MutableLiveData<News> = MutableLiveData()

    fun getNews(): LiveData<News> = news

    fun loadNews() {
        var newsApiClient = NewsApiClient()

        val apiCall = newsApiClient.getNewsWithQuery()

        apiCall.enqueue(
            object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    news.value = response.body()
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }

}