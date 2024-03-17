package com.example.mvvmcompose.repository

import com.example.mvvmcompose.api.TweetApi
import com.example.mvvmcompose.models.TweetListItem
import com.example.mvvmcompose.util.Constant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetApi: TweetApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets : StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategories() {
        val response = tweetApi.getCategories(Constant.API_KEY)
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)

        }
    }

    suspend fun getTweets(categori : String, API_KEY : String){
        val response = tweetApi.getTweets(categori,API_KEY)
        if (response.isSuccessful && response.body() !=null){
            _tweets.emit(response.body()!!)
        }
    }

}