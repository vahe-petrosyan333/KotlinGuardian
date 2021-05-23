package com.example.kotlinguardian

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinguardian.network.RetrofitClient
import com.example.kotlinguardian.response.Example

class Repository {

    fun getResult(): LiveData<Example> {
        val result: MutableLiveData<Example> = MutableLiveData()

        RetrofitClient.getGuardianService().getData().getResult {
            result.value = it
        }
        RetrofitClient.getGuardianService().getData().getResult(fail = {

        },suc = {

        })
        return result
    }
}