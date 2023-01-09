package com.wahyu.recipes.core.data.remote

import android.util.Log
import com.wahyu.recipes.core.data.remote.network.ApiResponse
import com.wahyu.recipes.core.data.remote.response.SearchRecipeApi
import com.wahyu.recipes.core.data.remote.network.ApiService
import com.wahyu.recipes.core.data.remote.response.RecipeInformationApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSource(private val apiService: ApiService) {
    private val token = "01db06631f77485381b23eec0e1d29f7"
    suspend fun getRecipe(type: String, size: Int): Flow<ApiResponse<SearchRecipeApi>> = flow {
        try {
            val client = apiService.getRecipe(token, size, type)
            if (client.isSuccessful) {
                val body = client.body() as SearchRecipeApi
                emit(ApiResponse.Success(body))
            } else {
                val error = client.errorBody()
                emit(ApiResponse.Error(error.toString()))
                Log.e(TAG, "getRecipe: Failed to fetch. ")
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
            Log.e(TAG, "getRecipe: Unexpected Error = $e")
        }
    }

    suspend fun getRecipeInformation(id: Int): Flow<ApiResponse<RecipeInformationApi>> = flow {
        try {
            val client = apiService.getRecipeInformation(token, id)
            if (client.isSuccessful) {
                val body = client.body() as RecipeInformationApi
                emit(ApiResponse.Success(body))
            } else {
                val error = client.errorBody()
                emit(ApiResponse.Error(error.toString()))
                Log.e(TAG, "getRecipe: Failed to fetch. ")
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
            Log.e(TAG, "getRecipe: Unexpected Error = $e")
        }
    }

    companion object {
        private const val TAG = "RemoteDataSource"
    }
}