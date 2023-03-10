package com.wahyu.recipes.core.data.remote

import android.util.Log
import com.wahyu.recipes.core.data.remote.network.ApiResponse
import com.wahyu.recipes.core.data.remote.network.ApiService
import com.wahyu.recipes.core.data.remote.response.RecipeInformationApi
import com.wahyu.recipes.core.data.remote.response.RecipesApi
import com.wahyu.recipes.core.data.remote.response.SearchRecipeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) {
    private val token = "01db06631f77485381b23eec0e1d29f7"
    suspend fun getRecipe(
        type: String? = null,
        size: Int? = null,
    ): Flow<ApiResponse<List<RecipesApi>>> = flow {
        try {
            val client = apiService.getRecipe(token, size, type)
            if (client.isSuccessful) {
                val body = client.body() as SearchRecipeApi
                val data = body.result
                emit(ApiResponse.Success(data))
            } else {
                val error = client.errorBody()
                emit(ApiResponse.Error(error.toString()))
                Log.e(TAG, "getRecipe: Failed to fetch. ")
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
            Log.e(TAG, "getRecipe: Unexpected Error = $e")
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getRecipeInformation(id: Int): Flow<ApiResponse<RecipeInformationApi>> =        flow {
        try {
            val client = apiService.getRecipeInformation(id, token)
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
    }.flowOn(Dispatchers.IO)

    companion object {
        private const val TAG = "RemoteDataSource"
    }
}