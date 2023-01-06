package com.dandt.navigationsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dandt.navigationsample.data.ArticlesItem
import com.dandt.navigationsample.databinding.ItemNewsBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder> (){

    var articleList: List<ArticlesItem> = ArrayList()

    inner class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.txtTitle.text = articleList.get(position).title
        holder.binding.txtDesc.text = articleList.get(position).description
    }

    override fun getItemCount(): Int = articleList.size
//    {
//        return articleList.size
//    }

    fun updateArticleList(articleList: List<ArticlesItem>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

}