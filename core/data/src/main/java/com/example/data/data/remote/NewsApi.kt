package com.example.data.data.remote

import com.example.data.data.remote.dto.NewsResponse
import com.example.data.data.util.Language
import com.example.data.data.util.SearchOpt
import com.example.data.data.util.SortType
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Date

interface NewsApi {
    @GET("/everything/")
    suspend fun getEverything(
        @Query("q") q: String?,
        @Query("searchIn") searchIn:SearchOpt?,
        @Query("sources") sources:String?,
        @Query("domains") domains:String?,
        @Query("excludeDomains") excludeDomains:String?,
        @Query("from") from: Date?,
        @Query("to") to: Date?,
        @Query("language") language: Language?,
        @Query("sortBy") sortType: SortType?,
        @Query("pageSize") pageSize:Int?,
        @Query("page") page:Int?,
        @Query("apiKey") apiKey: String
    ):Response<NewsResponse>
}