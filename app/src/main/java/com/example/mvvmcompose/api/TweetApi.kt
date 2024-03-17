package com.example.mvvmcompose.api

import com.example.mvvmcompose.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetApi {
    @GET("/v3/b/65f65660266cfc3fde99811f?meta=false")
    suspend fun getTweets(
        @Header("X-JSON-Path") category: String,
        @Header("X-Master-Key") APIKEY: String
    ): Response<List<TweetListItem>>

    @GET("/v3/b/65f65660266cfc3fde99811f?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(
        @Header("X-Master-Key") APIKEY: String
    ): Response<List<String>>
}