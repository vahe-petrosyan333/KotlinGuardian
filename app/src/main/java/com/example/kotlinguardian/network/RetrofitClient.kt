package com.example.kotlinguardian.network

import com.example.kotlinguardian.Constants.Companion.API_KEY
import com.example.kotlinguardian.Constants.Companion.ROOT_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    companion object {
        val retroit by lazy {
            getRetrofitClient()
        }

        fun getRetrofitClient(): Retrofit =
            Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkhttClient())
                .build()


        fun getGuardianService(): ApiService = getApiService()


        inline fun <reified T> getApiService(): T {
            return retroit.create(T::class.java)

        }

        fun provideOkhttClient(): OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(headerInterCceptor())
                .build()


    }


    class headerInterCceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
                .newBuilder().addHeader("api-key", API_KEY)
                .build()
            return chain.proceed(request)
        }
    }
}