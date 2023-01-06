package com.wahyu.recipes.core.data

import com.wahyu.recipes.core.data.local.LocalDataSource
import com.wahyu.recipes.core.data.remote.RemoteDataSource
import com.wahyu.recipes.core.data.remote.network.ApiResponse
import com.wahyu.recipes.core.data.remote.response.RecipeApiResponse
import com.wahyu.recipes.core.domain.repository.IRecipesRepository
import com.wahyu.recipes.core.model.DetailRecipes
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

class RecipesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IRecipesRepository {
    override fun getRecipes(): Flow<Async<List<Recipes>>> =
        object : NetworkBoundResource<List<Recipes>, List<RecipeApiResponse>>() {
            override fun loadFromDb(): Flow<List<Recipes>> {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<Recipes>?): Boolean {
                TODO("Not yet implemented")
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RecipeApiResponse>>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: List<RecipeApiResponse>) {
                TODO("Not yet implemented")
            }
        }.asFlow()

    override fun setFavoriteRecipes(recipes: DetailRecipes, state: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getRecipesInformation(id: Int): Flow<Async<DetailRecipes>> {
        TODO("Not yet implemented")
    }
}