package com.wahyu.recipes.core.data.remote.network

import com.wahyu.recipes.core.data.remote.response.RecipeInformationApi
import com.wahyu.recipes.core.data.remote.response.SearchRecipeApi
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
    ): Response<SearchRecipeApi>

    @GET("{id}/information")
    suspend fun getRecipeInformation(
        @Path("id") id: Int,
        @Query("apiKey") key: String,
    ): Response<RecipeInformationApi>
}