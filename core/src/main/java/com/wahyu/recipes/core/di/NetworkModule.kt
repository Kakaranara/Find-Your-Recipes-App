package com.wahyu.recipes.core.di

import com.wahyu.recipes.core.data.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val host = "api.spoonacular.com"
        val certPinner = CertificatePinner.Builder()
            .add(host, "sha256/KktT3Oom4jItTYGySxE2lm8lf3JitTxH0slUYd8dxOY=")
            .add(host, "sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
            .add(host, "sha256/Y9mvm0exBk1JoQ57f9Vm28jKo5lFm/woKcVxrYxu80o=")
            .build()

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .certificatePinner(certPinner)
            .build()
    }

    @Provides
    fun provideApiService(client: OkHttpClient): ApiService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()

        return retrofit.create(ApiService::class.java)
    }

    companion object {
        const val baseUrl = "https://api.spoonacular.com/recipes/"
    }
}