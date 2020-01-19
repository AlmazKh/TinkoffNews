package com.almaz.tinkoffnews.di.component

import androidx.appcompat.app.AppCompatActivity
import com.almaz.tinkoffnews.di.module.NewsFeedModule
import com.almaz.tinkoffnews.di.scope.ScreenScope
import com.almaz.tinkoffnews.view.NewsFeedActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
        modules = [
            NewsFeedModule::class
        ]
)
@ScreenScope
interface NewsFeedComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun withActivity(activity: AppCompatActivity): Builder

        fun build(): NewsFeedComponent
    }

    fun inject(newsFeedActivity: NewsFeedActivity)
//    fun inject(postFragment: PostFragment)
}
