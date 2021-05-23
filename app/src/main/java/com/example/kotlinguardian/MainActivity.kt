package com.example.kotlinguardian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinguardian.adapter.NewsAdapter
import com.example.kotlinguardian.viewModel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private val newsAdapter: NewsAdapter = NewsAdapter()
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViw()
        observerOnChange()


    }


fun initViw(){
    newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
    val recyclerView: RecyclerView = findViewById(R.id.rv_news)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = newsAdapter
}
    fun observerOnChange() {
        newsViewModel.getResult().observe(this@MainActivity) { example ->

            example.response?.results?.let { newsAdapter.setResult(it) }

        }
    }
}