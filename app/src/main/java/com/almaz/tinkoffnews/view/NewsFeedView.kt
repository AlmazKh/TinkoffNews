package com.almaz.tinkoffnews.view

import com.almaz.tinkoffnews.core.News

interface NewsFeedView {
    fun updateListView(list: List<News>)
    fun showProgress()
    fun hideProgress()
    fun navigateToDetails(news: News)
}
