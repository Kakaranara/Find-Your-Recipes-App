package com.wahyu.recipes.core.data.remote.network

import com.wahyu.recipes.core.data.remote.response.RecipeInformationResponse
import com.wahyu.recipes.core.data.remote.response.SearchRecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("complexSearch")
    suspend fun getRecipe(
        @Query("apiKey") key: String,
        @Query("number") size: Int? = null,
        @Query("type") type: String? = null,
    ): Response<SearchRecipeResponse>

    @GET("{id}/information")
    suspend fun getRecipeInformation(
        @Query("apiKey") key: String,
        @Path("id") id: Int,
    ): Response<RecipeInformationResponse>
}