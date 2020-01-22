package com.almaz.tinkoffnews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.almaz.tinkoffnews.R
import com.almaz.tinkoffnews.TinkoffNewsApp
import com.almaz.tinkoffnews.core.model.News
import com.almaz.tinkoffnews.presenter.NewsFeedPresenter
import com.almaz.tinkoffnews.view.base.MainActivity
import kotlinx.android.synthetic.main.fragment_news_feed.*
import javax.inject.Inject

const val NEWS_KEY = "news"

class NewsFeedFragment : Fragment(), NewsFeedView {

    @Inject
    lateinit var newsFeedPresenter: NewsFeedPresenter

    private var newsFeedAdapter: NewsFeedAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TinkoffNewsApp.appComponent
                .newsFeedComponent()
                .withActivity(activity as AppCompatActivity)
                .build()
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun updateListView(list: List<News>) {
        newsFeedAdapter?.submitList(list)
    }

    override fun showProgress() {
        swipeContainer.isRefreshing = true
    }

    override fun hideProgress() {
        swipeContainer.isRefreshing = false
    }

    override fun navigateToDetails(news: News) {
        val postBundle = Bundle()
        postBundle.putParcelable(NEWS_KEY, news)
        (activity as MainActivity).navigateTo(NewsFragment.toString(), postBundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        newsFeedPresenter.detachView()
    }

    companion object {
        fun newInstance() = NewsFeedFragment()
    }
}
