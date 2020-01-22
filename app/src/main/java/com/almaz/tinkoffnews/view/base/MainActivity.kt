package com.almaz.tinkoffnews.view.base

import android.os.Bundle
import com.almaz.tinkoffnews.R
import com.almaz.tinkoffnews.TinkoffNewsApp
import com.almaz.tinkoffnews.view.NewsFeedFragment
import com.almaz.tinkoffnews.view.NewsFragment

class MainActivity : BaseActivity() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun inject() {
        TinkoffNewsApp.appComponent
                .mainComponent()
                .withActivity(this)
                .build()
                .inject(this)
    }

    override fun setupView() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, NewsFeedFragment.newInstance()).commit()
    }

    fun navigateTo(fragment: String, arguments: Bundle?) {
        val transaction =
                supportFragmentManager.beginTransaction()
        when (fragment) {
            fragment -> {
                transaction.replace(
                        R.id.main_container,
                        NewsFragment.newInstance(arguments)
                )
            }
        }
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}