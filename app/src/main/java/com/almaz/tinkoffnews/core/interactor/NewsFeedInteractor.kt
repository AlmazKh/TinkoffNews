package com.almaz.tinkoffnews.core.interactor

import com.almaz.tinkoffnews.core.interfaces.NewsRepository
import com.almaz.tinkoffnews.core.model.News
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsFeedInteractor
@Inject constructor(
        private val newsRepository: NewsRepository
) {

    fun getNewsFromApi(): Single<List<News>> =
            newsRepository.getNewsFromApi()
                    .subscribeOn(Schedulers.io())
}