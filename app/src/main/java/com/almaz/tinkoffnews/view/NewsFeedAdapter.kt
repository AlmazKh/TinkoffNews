package com.almaz.tinkoffnews.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.almaz.tinkoffnews.R
import com.almaz.tinkoffnews.core.News
import kotlinx.android.extensions.LayoutContainer

class NewsFeedAdapter(
        private val newsLambda: (News) -> Unit
) : ListAdapter<News, NewsFeedAdapter.NewsFeedViewHolder>(NewsFeedDiffCallback()) {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsFeedViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        return NewsFeedViewHolder(inflater.inflate(R.layout.item_news, p0, false))
    }

    override fun onBindViewHolder(holder: NewsFeedViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            newsLambda.invoke(getItem(position))
        }
    }

    class NewsFeedViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(news: News) {


        }
    }

    class NewsFeedDiffCallback : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean = oldItem == newItem
    }
}