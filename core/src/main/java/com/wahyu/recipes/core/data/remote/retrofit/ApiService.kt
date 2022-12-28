package com.wahyu.recipes.core.data.remote.retrofit

import com.wahyu.recipes.core.data.remote.response.RecipeList
import com.wahyu.recipes.core.data.remote.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("complexSearch")
    suspend fun getRecipe(
        @Query("apiKey") key: String,
        @Query("number") size: Int? = null,
        @Query("type") type: String? = null,
    ): List<RecipeResponse>
}