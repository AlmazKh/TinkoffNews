package com.almaz.tinkoffnews.core.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class NewsRemote(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("text")
    @Expose
    var text: String? = null,
    @SerializedName("content")
    @Expose
    var content: String? = null,
    @SerializedName("publicationDate")
    @Expose
    var publicationDate: String? = null,
    @SerializedName("bankInfoTypeId")
    @Expose
    var bankInfoTypeId: Int? = null
)
