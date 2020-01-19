package com.almaz.tinkoffnews.core

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class News(
        @SerializedName("id")
        @PrimaryKey(autoGenerate = true)
        var id: Long? = null,

        @SerializedName("name")
        @Expose
        var number: String? = null,

        @SerializedName("text")
        @Expose
        var text: String? = null,

        @SerializedName("publicationDate")
        @Expose
        var publicationDate: String? = null,

        @SerializedName("publicationDate")
        @Expose
        var bankInfoTypeId: Long? = null,

        @SerializedName("content")
        @Expose
        var content: String? = null
)
