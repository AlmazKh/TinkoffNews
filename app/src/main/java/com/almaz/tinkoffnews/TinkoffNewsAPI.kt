package com.almaz.tinkoffnews

import com.almaz.tinkoffnews.core.model.ApiResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface TinkoffNewsAPI {
    @GET("v1/news")
    fun getNews(): Observable<ApiResponse>
}
