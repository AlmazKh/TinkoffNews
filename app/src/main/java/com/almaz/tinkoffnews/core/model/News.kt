package com.almaz.tinkoffnews.core.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    var id: String? ,
    var title: String?,
    var publicationDate: String?
) : Parcelable
