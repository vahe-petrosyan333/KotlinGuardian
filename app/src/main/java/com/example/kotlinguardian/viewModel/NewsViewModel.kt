package com.example.kotlinguardian.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinguardian.Repository
import com.example.kotlinguardian.response.Example

class NewsViewModel : ViewModel() {

    private val repository: Repository = Repository()

    fun getResult(): LiveData<Example> {
        return repository.getResult()
    }
}