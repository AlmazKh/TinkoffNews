package com.almaz.tinkoffnews

import android.app.Application
import com.almaz.tinkoffnews.di.component.AppComponent
import com.almaz.tinkoffnews.di.component.DaggerAppComponent
import com.almaz.tinkoffnews.di.module.AppModule

class TinkoffNewsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}
