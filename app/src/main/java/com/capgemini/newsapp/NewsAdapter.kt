package com.capgemini.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val newsList: List<News>,
                  val onSelection: (Int) -> Unit) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    inner class NewsHolder(inflated: View): RecyclerView.ViewHolder(inflated) {
        val img: ImageView = inflated.findViewById(R.id.imageView)
        val titleTextView: TextView = inflated.findViewById(R.id.titleT)
        val dateTextView: TextView = inflated.findViewById(R.id.dateT)
        val descrTextView: TextView = inflated.findViewById(R.id.descrT)
        val authorTextView: TextView = inflated.findViewById(R.id.authorT)

        init {
            itemView.setOnClickListener {
                onSelection(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        // inflate item xml and return viewholder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return NewsHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        // bind data to views
        val news = newsList[position]

        holder.authorTextView.text = news.author
        holder.dateTextView.text = news.publishedAt
        holder.descrTextView.text = news.description
        holder.titleTextView.text = news.title

        news.urlToImage?.let {
            Glide.with(holder.itemView).load(it).into(holder.img)
        }

    }
}