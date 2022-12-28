package com.wahyu.recipes.core.data.remote

import com.wahyu.recipes.core.data.remote.response.RecipeApiResponse
import com.wahyu.recipes.core.data.remote.retrofit.ApiConfig
import com.wahyu.recipes.core.data.remote.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(
    private val apiService: ApiService
) {
    suspend fun getRecipeList(): Flow<ApiResponse<List<RecipeApiResponse>>> = flow {
        val result = apiService.getRecipe(ApiConfig.token)
        if(result.isSuccessful){
            val data = result.body()
            data?.let {
                val recipe = data.result
                emit(ApiResponse.Success(recipe))
            } ?: emit(ApiResponse.Empty)
            emit(ApiResponse.Error("rer"))

        }else{

        }
    }
}