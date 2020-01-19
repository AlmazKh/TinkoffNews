package com.almaz.tinkoffnews.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        inject()
        setupView()
    }

    protected abstract fun inject()

    protected abstract fun setupView()
}
