package com.almaz.tinkoffnews.di.module

import com.almaz.tinkoffnews.core.NewsFeedInteractor
import com.almaz.tinkoffnews.di.scope.ScreenScope
import com.almaz.tinkoffnews.presenter.NewsFeedPresenter
import dagger.Module
import dagger.Provides

@Module
class NewsFeedModule {

    @ScreenScope
    @Provides
    fun provideNewsFeedPresenter(
            newsFeedInteractor: NewsFeedInteractor
    ): NewsFeedPresenter = NewsFeedPresenter(newsFeedInteractor)
}
