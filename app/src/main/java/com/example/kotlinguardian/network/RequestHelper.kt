package com.example.kotlinguardian

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



inline fun <reified T> Call<T>.getResult(noinline fail:(String)->Unit={},noinline suc:(T)->Unit){
    this.enqueue(object :Callback<T>{
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful){
                response.body()?.let {
                    suc(it)
                }?:fail(response.errorBody().toString())
            }else{
                fail("unknown")
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            fail(t.toString())
        }

    })
}