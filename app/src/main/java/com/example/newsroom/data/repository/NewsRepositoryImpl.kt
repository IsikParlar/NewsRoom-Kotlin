package com.example.newsroom.data.repository

import com.example.newsroom.data.remote.NewsApi
import com.example.newsroom.domain.model.Article
import com.example.newsroom.domain.repository.NewsRepository
import com.example.newsroom.util.Resource
import java.lang.Exception

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {
    override suspend fun getTopHeadlines(category: String): Resource<List<Article>> {
        return try {
            val response = newsApi.getBreakingNews(category = category)
            Resource.Success(response.articles)
        } catch (e: Exception) {
            Resource.Error(message = "Failed to fetch news ${e.message}")
        }
    }
}