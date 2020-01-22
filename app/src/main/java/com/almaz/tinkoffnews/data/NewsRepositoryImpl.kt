package com.almaz.tinkoffnews.data

import com.almaz.tinkoffnews.TinkoffNewsAPI
import com.almaz.tinkoffnews.core.interfaces.NewsRepository
import com.almaz.tinkoffnews.core.model.News
import com.almaz.tinkoffnews.core.model.NewsRemote
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class NewsRepositoryImpl
@Inject constructor(
        private val tinkoffNewsAPI: TinkoffNewsAPI
) : NewsRepository {

    override fun getNewsFromApi(): Single<List<News>> =
            Single.create {
                tinkoffNewsAPI.getNews()
                        .flatMap {
                            Observable.just(it.newsList)
                        }
                        .map { list ->
                            val listOfNews = mutableListOf<News>()
                            list.forEach {
                                listOfNews.add(mapRemoteNewsToLocalNews(it))
                            }

                        }
            }

//    private fun getNewsList(list: List<NewsRemote>): Single<List<News>> {
//        val listOfNews = mutableListOf<News>()
//        list.forEach {
//            listOfNews.add(mapRemoteNewsToLocalNews(it))
//        }
//
//        return Single.just(listOfNews)
//    }

    private fun mapRemoteNewsToLocalNews(newsRemote: NewsRemote): News =
            News(
                    newsRemote.id,
                    newsRemote.text,
                    newsRemote.publicationDate
            )
}
