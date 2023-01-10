package com.wahyu.recipes.core.data

import com.wahyu.recipes.core.data.local.LocalDataSource
import com.wahyu.recipes.core.data.remote.RemoteDataSource
import com.wahyu.recipes.core.data.remote.network.ApiResponse
import com.wahyu.recipes.core.data.remote.response.RecipeApi
import com.wahyu.recipes.core.domain.recipes.repository.IRecipesRepository
import com.wahyu.recipes.core.model.DetailRecipes
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

class RecipesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IRecipesRepository {
    override fun getRecipes(): Flow<Async<List<Recipes>>> =
        object : NetworkBoundResource<List<Recipes>, List<RecipeApi>>() {
            override fun loadFromDb(): Flow<List<Recipes>> {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<Recipes>?): Boolean {
                TODO("Not yet implemented")
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RecipeApi>>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: List<RecipeApi>) {
                TODO("Not yet implemented")
            }
        }.asFlow()

    override fun getRecipesInformation(id: Int): Flow<Async<DetailRecipes>> {
        TODO("Not yet implemented")
    }

    override fun setFavoriteRecipes(recipes: Recipes, detail: DetailRecipes, state: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getFavoriteRecipes(): Flow<Async<Recipes>> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteDetailRecipes(): Flow<Async<DetailRecipes>> {
        TODO("Not yet implemented")
    }
}