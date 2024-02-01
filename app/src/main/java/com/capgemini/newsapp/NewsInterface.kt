package com.capgemini.newsapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("top-headlines")
    suspend fun getTopHeadlines(@Query("country") code: String,
                        @Query("apiKey") key: String) : NewsResult

    companion object {
        val BASE_URL = "https://newsapi.org/v2/"

        fun getInstance() : NewsInterface {
            val retrofitInstance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofitInstance.create(NewsInterface::class.java)
        }
    }

}