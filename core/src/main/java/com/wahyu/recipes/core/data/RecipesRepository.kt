package com.wahyu.recipes.core.data

import com.wahyu.recipes.core.data.local.LocalDataSource
import com.wahyu.recipes.core.data.remote.RemoteDataSource
import com.wahyu.recipes.core.data.remote.network.ApiResponse
import com.wahyu.recipes.core.data.remote.response.RecipesApi
import com.wahyu.recipes.core.data.remote.response.RecipeInformationApi
import com.wahyu.recipes.core.domain.recipes.repository.IRecipesRepository
import com.wahyu.recipes.core.model.RecipeInformation
import com.wahyu.recipes.core.model.Recipes
import kotlinx.coroutines.flow.Flow

class RecipesRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : IRecipesRepository {
    override fun getRecipes(): Flow<Async<List<Recipes>>> =
        object : NetworkBoundResource<List<Recipes>, List<RecipesApi>>() {
            override fun loadFromDb(): Flow<List<Recipes>> {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: List<Recipes>?): Boolean {
                TODO("Not yet implemented")
            }

            override suspend fun createCall(): Flow<ApiResponse<List<RecipesApi>>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: List<RecipesApi>) {
                TODO("Not yet implemented")
            }
        }.asFlow()

    override fun getRecipesInformation(id: Int): Flow<Async<RecipeInformation>> =
        object : NetworkBoundResource<RecipeInformation, RecipeInformationApi>() {
            override fun loadFromDb(): Flow<RecipeInformation> {
                TODO("Not yet implemented")
            }

            override fun shouldFetch(data: RecipeInformation?): Boolean {
                TODO("Not yet implemented")
            }

            override suspend fun createCall(): Flow<ApiResponse<RecipeInformationApi>> {
                TODO("Not yet implemented")
            }

            override suspend fun saveCallResult(data: RecipeInformationApi) {
                TODO("Not yet implemented")
            }
        }.asFlow()

    override fun setFavoriteRecipes(recipes: Recipes, detail: RecipeInformation, state: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getFavoriteRecipes(): List<Recipes> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteDetailRecipes(id: Int): RecipeInformation {
        TODO("Not yet implemented")
    }
}