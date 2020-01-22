package com.almaz.tinkoffnews.presenter

import com.almaz.tinkoffnews.core.model.News
import com.almaz.tinkoffnews.core.interactor.NewsFeedInteractor
import com.almaz.tinkoffnews.view.NewsFeedView

class NewsFeedPresenter(
        private val newsFeedInteractor: NewsFeedInteractor
) : BasePresenter<NewsFeedView>() {

    fun updateNewsFeed() = newsFeedInteractor
            .getNewsFromApi()
            .doOnSubscribe { view?.showProgress() }
            .doAfterTerminate { view?.hideProgress() }
            .subscribe({
                view?.updateListView(it)
            }, {
                updateNewsFeedFromCache()
            })

    fun updateNewsFeedFromCache() {

    }

    fun onNewsClick(news: News) = view?.navigateToDetails(news)
}
