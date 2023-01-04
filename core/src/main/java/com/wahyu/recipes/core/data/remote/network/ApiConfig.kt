package com.wahyu.recipes.core.data.remote.network

import com.wahyu.recipes.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//! remove later
object ApiConfig {
    const val baseUrl = "https://api.spoonacular.com/recipes/"
    const val token = "01db06631f77485381b23eec0e1d29f7"
    fun service(): ApiService {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = run {
            if (BuildConfig.DEBUG) {
                OkHttpClient.Builder().addInterceptor(interceptor).build()
            } else {
                OkHttpClient.Builder().build()
            }
        }
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }
}