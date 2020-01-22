package com.almaz.tinkoffnews.di.component

import androidx.appcompat.app.AppCompatActivity
import com.almaz.tinkoffnews.di.module.MainModule
import com.almaz.tinkoffnews.di.scope.ScreenScope
import com.almaz.tinkoffnews.view.base.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        MainModule::class
    ]
)
@ScreenScope
interface MainComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun withActivity(activity: AppCompatActivity): MainComponent.Builder

        fun build(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}
