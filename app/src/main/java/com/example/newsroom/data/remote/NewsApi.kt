package com.example.newsroom.data.remote

import com.example.newsroom.domain.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    //GET https://newsapi.org/v2/everything?q=Apple&from=2023-05-31&sortBy=popularity&apiKey=API_KEY

    @GET("top-headlines")
    suspend fun getBreakingNews(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"
        const val API_KEY = "2e91c1c54d7e41aea7d8b320d9beacf3"
    }
}