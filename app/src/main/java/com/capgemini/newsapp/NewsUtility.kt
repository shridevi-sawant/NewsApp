package com.capgemini.newsapp

data class News(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

data class NewsResult(val articles: MutableList<News>)