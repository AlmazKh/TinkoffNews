package com.almaz.tinkoffnews.di.component

import com.almaz.tinkoffnews.di.module.AppModule
import com.almaz.tinkoffnews.di.module.NetModule
import com.almaz.tinkoffnews.di.module.RepoModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class,
            NetModule::class,
            RepoModule::class
        ]
)
interface AppComponent {
    fun mainComponent(): MainComponent.Builder
    fun newsFeedComponent(): NewsFeedComponent.Builder
}
