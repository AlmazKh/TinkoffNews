package com.almaz.tinkoffnews.core.interfaces

import com.almaz.tinkoffnews.core.model.News
import io.reactivex.Single

interface NewsRepository {
    fun getNewsFromApi(): Single<List<News>>
}
