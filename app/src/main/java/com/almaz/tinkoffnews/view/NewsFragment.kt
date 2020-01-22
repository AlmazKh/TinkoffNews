package com.almaz.tinkoffnews.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.almaz.tinkoffnews.R
import com.almaz.tinkoffnews.TinkoffNewsApp
import com.almaz.tinkoffnews.core.model.News
import com.almaz.tinkoffnews.view.base.MainActivity
import kotlinx.android.synthetic.main.item_news.tv_title

class NewsFragment : Fragment(), NewsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TinkoffNewsApp.appComponent
                .newsFeedComponent()
                .withActivity(activity!! as AppCompatActivity)
                .build()
                .inject(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                (activity as MainActivity).onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        activity?.actionBar?.setDisplayHomeAsUpEnabled(true)
        activity?.actionBar?.setDisplayShowHomeEnabled(true)
        return inflater.inflate(R.layout.fragment_news, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<News>("news")
        tv_title.text = arguments?.getParcelable<News>("news")?.title
    }

    companion object {
        fun newInstance(arguments: Bundle?): NewsFragment {
            val fragment = NewsFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}