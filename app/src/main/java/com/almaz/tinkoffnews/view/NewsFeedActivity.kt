package com.almaz.tinkoffnews.view

import androidx.recyclerview.widget.LinearLayoutManager
import com.almaz.tinkoffnews.R
import com.almaz.tinkoffnews.TinkoffNewsApp
import com.almaz.tinkoffnews.presenter.NewsFeedPresenter
import com.almaz.tinkoffnews.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_feed.*
import javax.inject.Inject

class NewsFeedActivity : BaseActivity(), NewsFeedView {

    @Inject
    lateinit var newsFeedPresenter: NewsFeedPresenter

    private var newsFeedAdapter: NewsFeedAdapter? = null

    override val layoutId: Int
        get() = R.layout.activity_news_feed

    override fun inject() {
        TinkoffNewsApp.appComponent
                .newsFeedComponent()
                .withActivity(this)
                .build()
                .inject(this)
    }

    override fun setupView() {
        newsFeedPresenter.attachView(this)

        swipeContainer.setOnRefreshListener {
            refreshNewsFeed()
        }

        rv_news_feed.apply {
            layoutManager = LinearLayoutManager(rootView.context)
        }
        initAdapter()
    }

    private fun initAdapter() {
        newsFeedAdapter = NewsFeedAdapter {
            newsFeedPresenter.onNewsClick(it)
        }
        rv_news_feed.adapter = newsFeedAdapter
        newsFeedPresenter.updateNewsFeed()
    }

    private fun refreshNewsFeed() {
        newsFeedPresenter.updateNewsFeed()
    }

    override fun showProgress() {
        swipeContainer.isRefreshing = true
    }

    override fun hideProgress() {
        swipeContainer.isRefreshing = false
    }

    override fun onDestroy() {
        super.onDestroy()
        newsFeedPresenter.detachView()
    }
}
