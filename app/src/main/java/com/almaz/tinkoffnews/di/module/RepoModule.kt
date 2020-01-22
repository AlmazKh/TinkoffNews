package com.almaz.tinkoffnews.di.module

import com.almaz.tinkoffnews.core.interfaces.NewsRepository
import com.almaz.tinkoffnews.data.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepoModule {

    @Binds
    @Singleton
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}