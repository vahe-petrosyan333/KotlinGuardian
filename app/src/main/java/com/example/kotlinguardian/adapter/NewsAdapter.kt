package com.example.kotlinguardian.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinguardian.R
import com.example.kotlinguardian.response.Result

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var resultLiveData:List<Result> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result: Result = resultLiveData[position]
        holder.tvTitle.text = result.webTitle
        holder.tvDescription.text = result.sectionName
        holder.let {
            Glide.with(holder.ivImage)
                .load(result.fields?.thumbnail)
                .into(holder.ivImage)
        }

    }

    override fun getItemCount(): Int {
        return resultLiveData.size
    }

    fun setResult(result: List<Result>) {
        this.resultLiveData = result
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        var tvDescription: TextView = itemView.findViewById(R.id.tv_description)
        var ivImage: ImageView = itemView.findViewById(R.id.iv_news_photo)



    }


}