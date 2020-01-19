package com.almaz.tinkoffnews.di.component

import com.almaz.tinkoffnews.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AppModule::class
        ]
)
interface AppComponent {
}