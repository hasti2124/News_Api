package com.example.news_api

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.news_api.Models.ArticlesItem
import com.example.news_api.databinding.NewsItemBinding

class NewsAdapter(var articles : List<ArticlesItem?>?) : Adapter<NewsAdapter.NewsHolder>() {

    lateinit var context : Context
    class NewsHolder(itemView: NewsItemBinding) : ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        context = parent.context
        var binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles?.size!!
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        Glide.with(context).load(articles?.get(position)?.urlToImage).into(holder.binding.imgPoster)
        holder.binding.txtTitle.text = articles?.get(position)?.title
    }
}