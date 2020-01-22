package com.almaz.tinkoffnews.core.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("resultCode")
    @Expose
    var resultCode: String? = null,
    @SerializedName("payload")
    @Expose
    var newsList: List<NewsRemote>? = null,
    @SerializedName("trackingId")
    @Expose
    var trackingId: String? = null
)
